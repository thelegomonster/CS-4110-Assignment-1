package assignment1;


public class Student {
	private String ID;						//For simplicity i'll just be using IDs with Student# (eg. Student1, Student2, etc...)
	private int Answer;						//Answers will be made as an int, and that will translate to ABCD or correct/incorrect, depending on question
	private Boolean submitted = false;		//Status if the student has submitted an answer yet or not, default false
	private int previous;					//Previous answer (there are probably better ways to implement this)
	
	public Student() {
		ID = "";							//Initialize the studentID as an empty string
		Answer = 0;							//Default answer will be 0, will be finalized when the question is decided
		previous = 0;
	}
	public Student(String newID, int newAnswer) {
		ID = newID;
		Answer = newAnswer;
	}
	
	String getID() {
		return ID;
	}
	void setID(String value) {
		ID = value;
	}
	int getAnswer() {
		return Answer;
	}
	void setAnswer(int value) {
		if(submitted == false)
			Answer = value;
		else {
			previous = Answer;
			Answer = value;
		}
	}
	Boolean getSubmitted() {
		return submitted;
	}
	void setSubmitted(Boolean value) {
		submitted = value;
	}
	public int getPrevious() {
		return previous;
	}

}
