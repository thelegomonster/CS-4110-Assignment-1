# CS-3560-Assignment-1
iVote Simulator

Java-based simulation tool based on the live poll idea used for class (Kahoot/Mentimeter). Purely desktop based console program, without web interactions/graphical UIs. 
 
 GOALS
  - Configure question types & candidate answers. Should support two types (both multiple choice and single choice ... ABCD, or "True/False"(?))
  
  - Allow students to submit answers. Each student should have a unique ID (String), and can submit an answer to the iVote service.
  
  - Voting service can first be configured with a given question type & candidate answers. Then it can start accepting submissions from students.
    - Important: when accepting submissions, each student can only submit one answer. If multiple are submitted only the latest one will be counted (eg. changed their mind).
 
  - Voting Service can output statistics of the submission results. (Don't need UI just output data)
 
  - Need a "SimulationDriver" to automatically simulate the whole process. The driver should...
    - create a question type and configure answers.
    - configure the question for iVote Service.
    - randomly generate a number of students and the answers.
    - submit all the students' answers to iVote Service.
    - call the iVote service output function to display the result.

