# Big Data Analytics – CPSC 5330

This repository contains lab solutions for the **Big Data Analytics (CPSC 5330)** course at **Seattle University**.

## Contents
- Lab solutions using Hadoop, Sqoop, Hive, Streaming, and MapReduce
- Setup instructions for AWS EC2 and Windows Subsystem for Linux (WSL)

---

## Environment Setup

Before starting the labs, make sure your environment is configured properly.

You will be working on an **EC2 instance** with the public image:  
`CPSC_5330_S25`

>  **Note:** AWS Lab access is provided by your course instructor. Make sure to use the AWS Lab environment assigned to you.

---

## Setup Steps

### Step 1: Create a Key Pair

1. Go to **EC2 → Network & Security → Key Pairs**
2. Click **Create Key Pair**
3. Set the following:
   - **Name:** (any name of your choice)
   - **Key pair type:** *RSA* (default)
   - **Private key file format:** `.pem` (change from `.ppk`)
4. Click **Create Key Pair**

---

### Step 2: Launch Instance from Public Image

1. Navigate to **EC2 → Images → AMIs**
2. In the search bar, look for `CPSC_5330_S25`
   - Ensure you're searching under **Public Images**
3. Select the image and click **Launch Instance**
4. Set the following:
   - **Instance name:** (your choice)
   - **Instance type:** `m5.large`
   - **Key pair (login):** select the one you created in Step 1
   - Leave the rest as default
5. Click **Launch Instance**

---

### Step 3: Install Windows Subsystem for Linux (WSL)

Open PowerShell or Command Prompt and run:

```bash
wsl --install --distribution ubuntu
whoami
pwd
touch .hushlogin
ls /mnt/c/Users/<your-windows-username> | head -n 5
```
The directory /mnt/c/Users/<your-windows-username> is your Windows file system
It’s different from your Linux home directory (/home/<linux-user>) and is useful for sharing files between Linux and Windows.

When you open Windows Terminal, it may default to PowerShell.
Use the dropdown ⌄ to open a new Ubuntu session.

These are the basic steps you are suppose to follow before starting with labs.


Note: I know this course can be a pain, but here I am sharing the solutions. I struggled a lot to get these labs done on time, and I don’t want others to go through the same frustration.
So here you’ll find complete solutions for all the labs throughout the course. If you face any difficulty with any part, feel free to email me at fshah1@seattleu.edu.

