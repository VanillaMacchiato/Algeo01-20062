# Tugas Besar Algeo 1

> **Kelompok 42**  
> _(The Answer of Life)_  
> Rifqi Naufal Abdjul (13520062)  
> Amar Fadil (13520103)  
> Vito Ghifari (13520153)

![Build and Coverage](https://github.com/VanillaMacchiato/Algeo01-20062/actions/workflows/main.yml/badge.svg)
[![codecov](https://codecov.io/gh/VanillaMacchiato/Algeo01-20062/branch/main/graph/badge.svg?token=0RLTWCO56O)](https://codecov.io/gh/VanillaMacchiato/Algeo01-20062)

## Coverage Status
[![codecov](https://codecov.io/gh/VanillaMacchiato/Algeo01-20062/branch/main/graph/tree.svg?token=0RLTWCO56O)](https://codecov.io/gh/VanillaMacchiato/Algeo01-20062)

## Table of Contents

- [General Information](#general-information)
- [Directory Structure](#directory-structture)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Screenshots](#screenshots)
- [Setup](#setup)
- [Usage](#usage)
- [Project Status](#project-status)
- [Room for Improvement](#room-for-improvement)
- [Acknowledgements](#acknowledgements)

## General Information

**Tugas Besar Algeo 1** merupakan project yang menggunakan bahasa pemrograman Java untuk menyelesaikan problem pada aljabar linier & geometris. Salah satu problem yang dapat diselesaikan dengan project ini adalah mencari solusi sistem persamaan linear. Proyek ini berbasis GUI dan mendukung file (.txt) sebagai input atau output. Pada utamanya, project ini ditujukan untuk memenuhi tujuan akademik.

## Directory Structure

Project ini memiliki group id `alingeo` dengan artifact id `matriks`. Secara umum, package layout ditunjukkan oleh tree berikut:

```
│───alingeo                // group id.
│   └───matriks            // artifact id.
        ├───io             // package IO untuk Parsing.
│       ├───problem        // package Problem untuk Interpolation dan Regression.
│       ├───solver         // package Solver untuk SPL, Determinan, dan Invers.
│       └───ui             // package UI untuk GUI integrasi main program.
```

Secara lengkap, project ini memiliki direktori sebagai berikut:

```
├───.github
│   └───workflows           // Workflow CI
├───bin                     // Build folder
│   ├───classes             // .class dari source
│   ├───libs                // Library tambahan
│   └───test-classes        // .class dari test
├───src                     // Source file utama
├───test                    // Screenshot program
└───unit                    // Source file untuk Unit Test
```

Setiap folder source file atau classes baik utama ataupun unit test akan mengikuti package layout yang sudah tertera sebelumnya.

## Technologies Used

- Java JDK 14.0.2
- Maven 3.2.0

## Features

Fitur yang kami implementasi dalam program ini seperti

- Penyelesaian perhitungan seperti SPL, determinan, dan invers
- Penyelesaian permasalahan seperti Regresi Linear dan Interpolasi polinom
- GUI yang mudah digunakan
- Formatting number agar lebih komprehensif sesuai kebutuhan
- I/O melalui file yang berisikan input atau output program

## Screenshots

![Example1](https://raw.githubusercontent.com/VanillaMacchiato/Algeo01-20062/main/testcase/1a.png?token=AIKLQ3OXFTYC5NNZGZP4T4LBL66B2)

Screenshot lebih lengkap dapat dilihat pada [folder test](./test/).

## Setup

Untuk melakukan build project, jalankan langkah berikut:

1. Clone repo menggunakan command berikut
   > `git clone https://github.com/VanillaMacchiato/Algeo01-20062.git`
2. Build Repo menggunakan maven untuk menghasilkan folder bin
   > `mvn clean install`
3. Untuk menjalankan program, bisa dengan menjalankan file JAR dengan suffix `-full.jar` yang berada di bin
   atau gunakan command berikut untuk menjalankan dengan file class:
   > `java -cp libs/AbsoluteLayout.jar;classes alingeo.matriks.ui.Main`

   Pastikan anda telah change directory ke dalam folder `bin` pada project ini untuk menjalankan file class.

Pada repo ini, telah dijalankan CI untuk build project secara otomatis.
Hasil build dapat dilihat pada branch `build`.

## Usage

Dengan menjalankan program, akan memunculkan GUI yang komprehensif untuk digunakan, berikut ada beberapa contoh input untuk setiap modul:

### SPL

Masukan berupa Augmented Matrix  
Khusus untuk metode crammer dan matriks balikan ukuran matriks harus sesuai (N x N+1)

> `1 2 3 4 5`  
> `2 2 3 4 5`  
> `3 3 3 4 5`  
> `4 4 4 4 5`

### Determinan

Masukan berupa Matriks persegi berukuran >= 2x2

> `1 2 3`  
> `4 5 6`  
> `7 8 9`

### Invers

Masukan berupa Matriks persegi berukuran >= 2x2

> `3 2 1`  
> `5 1 2`  
> `7 1 2`

### Interpolasi

Masukan N (jumlah points), Point, dan X yang ingin di prediksi

> `3` (N)  
> `1 2` (point)  
> `2 3` (point)  
> `4 5` (point)  
> `3` (X)

### Regresi

Masukan N (banyak suku), Persamaan linear ganda, dan Xk yang ingin di prediksi

> `3` (N)  
> `1 2 3 4` (Pers)  
> `6 1 2 9` (Pers)  
> `2 1 4 7` (Pers)  
> `5 2 1` (Xk)

## Project Status

Karena kami membuat project ini dengan niatan menyelesaikan tugas, **kami tidak akan melanjutkan project ini** selain terdapat potensi atau minat dari pihak luar.

## Room for Improvement

Dari kami, terdapat beberapa fitur yang seharusnya bisa dikembangkan, tetapi dikarenakan adanya _time constraint_ sehingga kita memutuskan untuk tidak mengembangkannya.  
FItur tersebut seperti:

- Pembentuk matriks augmented dari persamaan SPL
- Visualisasi/penggambaran proses pembentukan matriks eselon menggunakan OBE
- Penulisan persamaan menggunakan LaTeX
- Grafik interpolasi dan grafik regresi
- Batch input/output file txt

## Acknowledgements

Selama project, kami sangat terbantu dengan yang disebutkan di bawah ini.

- Amar Fadil, mengarahkan untuk melakukan best practice untuk menyusun kode.
- Stackoverflow, yang membantu men-debug code ketika kita membuat kesalahan.
- Pak Rinaldi Munir, sebagai dosen kami dalam matkul aljabar linier dan geometri yang mengajarkan kami konsep matematis program ini.
