package assignment1;
import java.util.Random;
import java.util.Scanner;

/* ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * Java-based simulation tool based on the live poll idea used for class (Kahoot/Mentimeter).
 * Purely desktop based console program, without web interactions/graphical UIs. 
 * 
 * GOALS
 * [x] - Configure question types & candidate answers. Should support two types (both multiple choice and single choice ... ABCD, or "True/False"(?))
 * 
 * [x] - Allow students to submit answers. Each student should have a unique ID (String), and can submit an answer to the iVote service.
 * 
 * [x] - Voting service can first be configured with a given question type & candidate answers. Then it can start accepting submissions from students.
 * 			Important: when accepting submissions, each student can only submit one answer. If multiple are submitted only the latest one will be counted (eg. changed their mind).
 * 
 * [x] - Voting Service can output statistics of the submission results. (Don't need UI just output data)
 * 
 * [x] - Need a "SimulationDriver" to automatically simulate the whole process. The driver should...
 * 			1. [x] - create a question type and configure answers.
 * 			2. [x] - configure the question for iVote Service.
 * 			3. [x] - randomly generate a number of students and the answers.
 * 			4. [x] - submit all the students' answers to iVote Service.
 * 			5. [x] - call the iVote service output function to display the result.
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
public class SimulationDriver {

	public static void main(String[] args) {
//Output introduction and prompt for question type
		System.out.println("----- Super Fantastic Poll Program -----");
		int choice = 0;
		Boolean Flag = false;
		Question myQuestion = new Question();
		Scanner sc = new Scanner(System.in);
		
		while(Flag == false) {
			System.out.println("What type of question would you like to ask? (Enter 1 or 2)");
			System.out.println("1) Multiple Choice");
			System.out.println("2) True/False");
			choice = Integer.parseInt(sc.nextLine());			//REMINDER TO SELF: Try not to mix nextInt() and nextLine() when using Scanner, since nextInt() does not pick up on newline char(?)
			
//Initialize the question type
			//if Multiple Choice
			if(choice == 1) {						
				myQuestion.setQuestionType(choice);
				Flag = true;
				break;
			}
			//if Correct/Incorrect
			else if(choice == 2) {					
				myQuestion.setQuestionType(choice);
				Flag = true;
				break;
			}
			else {
				System.out.println("Error: Please input a valid integer (1 or 2)");
			}
		}
		System.out.println();
//Obtain question to be asked 
		System.out.print("Enter Question: ");
		String askedQuestion = "";
		askedQuestion = sc.nextLine();
		myQuestion.setQuestion(askedQuestion);
		
//Set answers
		//if Multiple Choice
		if(choice == 1) {
			System.out.println("How many choices do you wish to have?");
			int answerAmount = 0;
			answerAmount = Integer.parseInt(sc.nextLine());
		
			//Fill in answer options, A -> whatever
			char alphabet = 'A';
			for(int i = 0; i < answerAmount; i++) {
				System.out.print(alphabet + ") ");
				String input = "";
				input = sc.nextLine();
				myQuestion.addToChoicesList(input);
				alphabet++;
			}
		}
		//if True/False
		else if(choice == 2) {
			//Fill in answer options (T/F)
			myQuestion.addToChoicesList("True");
			myQuestion.addToChoicesList("False");
		}
		
//Begin asking Students, create Students and their answers
		System.out.println("~~ Asking Question ~~");
		//For simplicity (or laziness, depending on how you see it) i'll just use two parallel arrays to hold the student IDs and answers
		int max = 20;
		int min = 1;
		Random rand = new Random();
		int numStudents = rand.nextInt((max - min) + 1) + min;				//randomly decide anywhere from 1 to 20 students created
		Student [] arrayStudents = new Student[numStudents];				//array that will hold the randomly generated student (for testing i'll be using Student1, Student2, etc... as IDs)

		//Procedurally generate the Student IDs and choose a random answer
		rand = new Random();												//New seed for Student answers
		for(int i = 0; i < numStudents; i++) {
			arrayStudents[i] = new Student("Student" + i, rand.nextInt(myQuestion.getChoicesListSize()));
		}

		
//Submit answers
		VotingService newVote = new VotingService();
		newVote.configureService(choice, myQuestion);
		for(int i = 0; i < numStudents; i++) {
			newVote.submit(arrayStudents[i]);
		}	
		
//Output Voting Statistics
		newVote.output();
		System.out.println("Total Number of Students = " + numStudents);
		
		sc.close();
		
	}//end of main
}
