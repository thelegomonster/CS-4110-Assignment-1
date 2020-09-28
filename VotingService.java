package assignment1;

public class VotingService {
	private int questionType = 1;				//Default type is multiple choice (1)
	private Question question;					//The question itself, along with it's properties
	
	void configureService(int type, Question newQuestion) {
		questionType = type;
		question = newQuestion;
	}
	void submit(Student person) {
		//if the person has not submitted already
		if(person.getSubmitted() == false) {
			question.updateAnswerList(person.getAnswer(), 1);
			person.setSubmitted(true);
		}
		//if the student has already submitted an answer
		else {
			question.updateAnswerList(person.getPrevious(), -1);		//find old answer and remove it from count
			question.updateAnswerList(person.getAnswer(), 1);			//Update with new answer
		}
	}
	void output() {
		System.out.println();
		System.out.println("---------- Statistics ----------");
		//if multiple choice
		if(questionType == 1) {
			char alphabet = 'A';
			for(int i = 0; i < question.getChoicesListSize(); i++) {
				System.out.print(alphabet + ": ");
				System.out.println(question.getAnswerList(i));
				alphabet++;
			}
		}
		//if not multiple choice
		else {
				System.out.println("True: " + question.getAnswerList(0));
				System.out.println("False: " + question.getAnswerList(1));
		}
	}
}
