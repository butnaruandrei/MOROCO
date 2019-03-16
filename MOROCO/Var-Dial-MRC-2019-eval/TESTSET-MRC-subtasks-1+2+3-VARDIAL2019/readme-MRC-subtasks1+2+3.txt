== Data Format ==

The test data contains the following file:

	test.txt - testing set

Each line in the test.txt file is in the format:

	text-sample 1
	text-sample 2
	...
	text-sample N


== Submission ==

Each participant is allowed to submit 3 runs per subtask until March 11 (23:59 GMT) to:
	
	raducu.ionescu@gmail.com 

Each line in the submission file subtask-X-run-Z-[team_name].txt file is in the format:

	label 1
	label 2
	...
	label N

The labels must be given in the same order as the test samples listed in test.txt. The participants must provide labels for all the test samples, irrespective of the subtask. Each submission (run) must be accompanied by a subtask-X-readme-Z-[team_name].txt file containing a one-paragraph description of the respective submission, where X is the subtask number (1, 2 or 3) and Z is the run number (1, 2 or 3). 

For example, if the team name is "Ghostbusters", the first submission to subtask 3 should contain two files:
	subtask-3-run-1-Ghostbusters.txt
	subtask-3-readme-1-Ghostbusters.txt


== Unique MRC Test Set ==

The provided test set is unique for all three MRC subtasks 1, 2 and 3. Although you are requested to provide labels for all test samples, you will be evaluated on the corresponding subsets (Moldavian or Romanian) for subtasks 2 and 3. The subsets are not disclosed, as this would compromise the evaluation for subtask 1.


== MRC Subtasks Description ==

In the Moldavian vs. Romanian Cross-topic (MRC) Identification shared task we provide participants with the MOROCO data set [1] which contains Moldavian (MD) and Romanian (RO) samples of text collected from the news domain. 

Subtask 1 is a binary classification by dialect task, in which a classification model is required to discriminate between the Moldavian (MD) and the Romanian (RO) dialects. 

Subtask 2 is a Moldavian to Romanian cross-dialect multi-class classification by topic task, in which a model is required to classify the samples written in the Romanian dialect into six topics (categories), using samples written in the Moldavian dialect for training.

Subtask 3 is a Romanian to Moldavian cross-dialect multi-class classification by topic task, in which a model is required to classify the samples written in the Moldavian dialect into six topics (categories), using samples written in the Romanian dialect for training.
 
The subtasks are closed, therefore, participants are not allowed to use external data to train their models, nor internal training data provided for a different MRC subtask. Participants can participate in one, two or all three MRC subtasks.


== Evaluation ==

The macro-averaged F1 score will be used to rank the participants.

