# MOROCO: The **Mo**ldavian and **Ro**manian Dialectal **Co**rpus

The test for the MRC shared task at VarDial 2019 can be downloaded from [here](MOROCO/TESTSET-MRC-subtasks-1+2+3-VARDIAL2019.zip).

## 1. License Agreement

**Copyright (C) 2018 - Andrei M. Butnaru, Radu Tudor Ionescu**

This package contains free data and software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.

This data set and software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

 You should have received a copy of the GNU General Public License along with this data set and software (see COPYING.txt package file). If not, see the:
 [GNU License Agreement](http://www.gnu.org/licenses/).


## 2. Citation

Please cite the corresponding work (see citation.bib file to obtain the citation in BibTex format) if you use this data set and software (or a modified version of it) in any scientific work:

**[1] Andrei M. Butnaru, Radu Tudor Ionescu. MOROCO: The Moldavian and Romanian Dialectal Corpus. ArXiv, 2019 [(link to paper)](https://arxiv.org/abs/1901.06543).**


## 3. Description

#### General Information

The MOROCO data set contains Moldavian and Romanian samples of text collected from the news domain. The samples belong to one of the following six topics:
- culture
- finance
- politics
- science
- sports
- tech

The data set is divided into three subsets:
- training (21719 samples)
- validation (5921 samples)
- test (5924 samples)

For each sample, the data set provides corresponding dialectal and category labels. This enables to perform several tasks:
- binary classification by dialect: the task is to discriminate between the Moldavian and the Romanian dialects
- Moldavian intra-dialect multi-class classification by topic: the task is to classify the samples written in the Moldavian dialect into six topics
- Romanian intra-dialect multi-class classification by topic: the task is to classify the samples written in the Romanian dialect into six topics
- Moldavian => Romanian cross-dialect multi-class classification by topic: the task is to classify the samples written in the Romanian dialect into six topics, using a model trained on samples written in the Moldavian dialect
- Romanian => Moldavian cross-dialect multi-class classification by topic: the task is to classify the samples written in the Moldavian dialect into six topics, using a model trained on samples written in the Romanian dialect

The samples are preprocessed in order to eliminate named entities. This is required to prevent classifiers from taking the decision based on features that are not related to the dialect or the topics. For example, named entities that refer to city names in Romania or Republic of Moldova can provide clues about the dialect, while named entities that refer to politicians or football players names can provide clues about the topic. For more details, please read the paper [1].

#### Data Organization

The data set is divided in three folders, corresponding to the three subsets for training, validation and testing. In each subset there are three .txt files:
- ###### samples.txt

  The samples.txt file contains one sample per row. The format of each row is the following:
  ```
  ID_1    SampleText_1
  ID_2    SampleText_2
  ...
  ID_n    SampleText_n
  ```

- ###### dialect_labels.txt

  The dialect_labels.txt file contains one dialect label per row. The format of each row is the following:
  ```
  ID_1    DialectLabel_1
  ID_2    DialectLabel_2
  ...
  ID_n    DialectLabel_n
  ```

  The labels are associated as follows:
  - 1 => Moldavian
  - 2 => Romanian

- ###### category_labels.txt

  The category_labels.txt file contains one category label per row. The format of each row is the following:
  ```
  ID_1    CategoryLabel_1
  ID_2    CategoryLabel_2
  ...
  ID_n    CategoryLabel_n
  ```

  The labels are associated as follows:
  - 1 => culture
  - 2 => finance
  - 3 => politics
  - 4 => science
  - 5 => sports
  - 6 => tech

The IDs in each file are listed in exactly the same order. This means that, for a given index i (1 <= i <= n), the `SampleText_i` identified by `ID_i` has the dialectal label `DialectLabel_i` and the category label `CategoryLabel_i`.


## 4. Website

The MOROCO data set and accompanying software is available at:
[https://github.com/butnaruandrei/MOROCO](https://github.com/butnaruandrei/MOROCO)


## 5. Software Usage

For convenience, we provide Python and Java code to load the data set in the memory. The code has no dependencies on third-party libraries. It is straight forward to
compile and run the code.

#### Java

To load the MOROCO data set in Java, use the following commands:
```
javac DataSetLoader.java
java DataSetLoader
```

#### Python

To load the MOROCO data set in Python, use the following command:
```
python loadDataSet.py
```


## 6. Feedback

 We are happy to hear your feedback and suggestions at: raducu[dot]ionescu{at}gmail(dot)com
