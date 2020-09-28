package assignment1;
import java.util.Vector;

public class Question {
	private String question = "";									//The question itself
	private int questionType;										//1 = Multiple Choice, 2 = Correct/Incorrect
	//private int correctAnswer;										//option that denotes the correct answer
	private Vector<String> choicesList = new Vector<String>(0);		//vector that will hold the different choices to the question
	private Vector<Integer> answerList = new Vector<Integer>(0);	//parallel vector that will hold the submitted answer counts for each option 
	
	public Question() {
		questionType = 1;											//question will be multiple choice by default
		//correctAnswer = 1;											//answer will be option 1 by default
	}
//	public Question(int type) {										//should be limited to 1 or 2 in SimulationDriver
//		questionType = type;
//		correctAnswer = 1;											
//	}
	
	void setQuestion(String value) {
		question = value;
	}
	String getQuestion() {
		return question;
	}
	void setQuestionType(int type) {
		questionType = type;
	}
	int getQuestionType() {
		return questionType;
	}
//	void setCorrectAnswer(int value) {
//		correctAnswer = value;
//	}
//	int getCorrectAnswer() {
//		return correctAnswer;
//	}
	//Update choices and add element to the parallel answerList vector
	void addToChoicesList(String value) {
		choicesList.add(value);
		answerList.add(0);
	}
	String getChoicesList(int index) {
		return choicesList.get(index);
	}
	int getChoicesListSize() {										//I guess technically I shouldn't use the actual variable name in the function name if i were 100% serious about security? Assuming that's an issue
		return choicesList.size();
	}
	//Increment answerList when student submits answer
	void updateAnswerList(int index, int value) {
		answerList.set(index, answerList.get(index)+value);
	}
	int getAnswerList(int index) {
		return answerList.get(index);
	}
	
}
