import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordLengthCount {

    // === Utility to clean words ===
    public static class Strings {
        public static String removePunctuation(String s) {
            return s.replaceAll("\\p{Punct}", "");
        }

        public static String downCase(String s) {
            return s.toLowerCase();
        }
    }

    public static class TokenizerMapper extends Mapper<Object, Text, IntWritable, Text> {

        private final static IntWritable wordLength = new IntWritable();
        private Text wordText = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                String raw = itr.nextToken();
                String cleaned = Strings.downCase(Strings.removePunctuation(raw)).trim();
                if (!cleaned.isEmpty()) {
                    wordLength.set(cleaned.length());
                    wordText.set(cleaned);
                    context.write(wordLength, wordText);
                }
            }
        }
    }

    public static class IntSumReducer extends Reducer<IntWritable, Text, IntWritable, Text> {

        private Text result = new Text();

        public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            int count = 0;
            String sampleWord = "";

            for (Text val : values) {
                if (count == 0) {
                    sampleWord = val.toString(); // grab the first word as sample
                }
                count++;
            }

            result.set(sampleWord + "\t" + count);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Longest Words by Length");

        job.setJarByClass(WordLengthCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setReducerClass(IntSumReducer.class);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
