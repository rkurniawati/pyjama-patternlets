# Pyjama patternlets

Java patternlets for OpenMP with [Pyjama](https://github.com/ParallelAndReconfigurableComputing/Pyjama). 

These Pyjama OpenMP patternlets are reusable solution that are based on the original OpenMP patternlets in C language by Joel Adams:

Adams, Joel C. "Patternlets: A Teaching Tool for Introducing Students to Parallel Design Patterns." _2015 IEEE International Parallel and Distributed Processing Symposium Workshop_. IEEE, 2015.

## Getting started

If you want to explore these patternlets, you can open the [Jupyter notebook provided](https://github.com/rkurniawati/pyjama-patternlets/blob/master/Java_OpenMP_Patternlets.ipynb) in [Google Colab](https://colab.research.google.com/github/rkurniawati/pyjama-patternlets/blob/master/Java_OpenMP_Patternlets.ipynb). 

Alternatively, you can check out the companion [e-book](https://pdcbook.calvin.edu/pdcbook/RaspberryPiHandout/02simple_program/index.html), which is made available by [CSinParallel](https://csinparallel.org/index.html) group and work through the examples on your machine. 
 - To start compiling and running the examples, first run `make` in the `lib` directory. This will download Pyjama compiler and runtime from [Tennessee Tech's iPDC website](https://www.csc.tntech.edu/pdcincs/index.php/installation/). 
 - Each sample program directory contains a Makefile. To compile and run the example, type `make run` in the directory. This will invoke Pyjama compiler to preprocess the Java file, run the Java compiler on the parallelized source code, then it will launch the Java VM with the parallelized code along with Pyjama runtime. 

## Creating New Java Program with Pyjama

To create a new Java program from scratch with Pyjama, you can use the following [pyjama-starter Maven archetype](https://github.com/rkurniawati/pyjama-starter-archetype/tree/master). 


