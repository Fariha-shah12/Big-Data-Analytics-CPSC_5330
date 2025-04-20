#!/usr/bin/python3

print("Hello")
def calculate_richness(unique_word_file):
    unique_words = 0
    total_words = 0
    with open(unique_word_file, 'r') as file:
        for line in file:
            parts  = line.strip().split('\t')
            if len(parts) ==2:
                words, count = parts
                unique_words +=1
                total_words += int(count)
    
    return unique_words/total_words

#Shakespeare 
file_shakespeare ='/home/ubuntu/word-count-shakespeare-clean.txt'
richness_ratio = calculate_richness(file_shakespeare)
print(f"Richness of Vocabulary for Shakespeare: {richness_ratio: .4f}")
#Austen
file_austin ='/home/ubuntu/word-count-austen-clean.txt'
richness_ratio = calculate_richness(file_austin)
print(f"Richness of Vocabulary for Austen: {richness_ratio: .4f}")
#King James Bible
file_bible ='/home/ubuntu/word-count-bible-clean.txt'
richness_ratio = calculate_richness(file_bible)
print(f"Richness of Vocabulary for King James bible: {richness_ratio: .4f}")
