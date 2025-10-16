# Huffman Compression in Java

This repository contains a Java implementation of the Huffman coding algorithm, a classic method for lossless data compression. The project was developed for a data structures course in the Computer Science program.

The program reads text from an input file, builds a Huffman tree based on character frequencies, and generates the corresponding compressed binary codes, writing the result to an output file.

## Core Concepts & Data Structures

This implementation makes use of several fundamental data structures to build the compression algorithm:

* **Priority Queue (`Fila`):** Used to efficiently build the Huffman tree by always selecting the two nodes with the lowest frequencies.
* **Binary Tree (`No`):** The main structure where leaf nodes represent characters and the path from the root to a leaf represents its binary code.
* **Linked List (`Lista`):** Used to store the character-to-code mappings generated from the tree.

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Lucasbschuck/Huffman-Compression-Java.git](https://github.com/Lucasbschuck/Huffman-Compression-Java.git)
    cd Huffman-Compression-Java
    ```

2.  **Compile the project:**
    You will need a Java Development Kit (JDK) installed.
    ```bash
    javac *.java
    ```

3.  **Execute the program:**
    The program will read from `entrada.txt` and write the compressed output to `saida.txt`. Ensure `entrada.txt` exists in the same directory.
    ```bash
    java Main
    ```
---
