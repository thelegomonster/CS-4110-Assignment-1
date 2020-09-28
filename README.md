# CS-3560-Assignment-1
iVote Simulator


 Java-based simulation tool based on the live poll idea used for class (Kahoot/Mentimeter).
 Purely desktop based console program, without web interactions/graphical UIs. 
 
 GOALS
 [x] - Configure question types & candidate answers. Should support two types (both multiple choice and single choice ... ABCD, or "True/False"(?))
 
 [x] - Allow students to submit answers. Each student should have a unique ID (String), and can submit an answer to the iVote service.
 
 [x] - Voting service can first be configured with a given question type & candidate answers. Then it can start accepting submissions from students.
 			Important: when accepting submissions, each student can only submit one answer. If multiple are submitted only the latest one will be counted (eg. changed their mind).
 
 [x] - Voting Service can output statistics of the submission results. (Don't need UI just output data)
 
 [x] - Need a "SimulationDriver" to automatically simulate the whole process. The driver should...
 			1. [x] - create a question type and configure answers.
 			2. [x] - configure the question for iVote Service.
 			3. [x] - randomly generate a number of students and the answers.
 			4. [x] - submit all the students' answers to iVote Service.
 			5. [x] - call the iVote service output function to display the result.

