/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	//create shut up variable
	boolean shutUp = false;

	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		if(statement.isEmpty()){
			return "I can't hear you, can you please speak up?";
		}

		//preventing a keyword from being triggered by a word inside a word,
		// adding spaces to string and accounting for punctuation
		if(statement.contains("?")){
			int questionAt = statement.indexOf("?");
			String statement1 = statement.substring(0, questionAt);
			if (statement1.length() != (statement.length() - 1)) {
				String statement2 = statement.substring(questionAt);
				statement = " " + statement1 + statement2 + " ?";
			} else {
				statement = " " + statement1 + " ?";
			}
		}
		else if (statement.contains(".")){
			int periodAt = statement.indexOf(".");
			String statement1 = statement.substring(0, periodAt);
			if (statement1.length() != (statement.length() - 1)) {
				String statement2 = statement.substring(periodAt);
				statement = " " + statement1 + statement2 + " .";
			} else {
				statement = " " + statement1 + " .";
			}
		}
		else if (statement.contains("!")){
			int exclaimAt = statement.indexOf("!");
			String statement1 = statement.substring(0, exclaimAt);
			if (statement1.length() != (statement.length() - 1)) {
				String statement2 = statement.substring(exclaimAt);
				statement = " " + statement1  + statement2 + " !";
			} else{
				statement = " " + statement1 + " !";
			}
		} else {
			statement = " " + statement + " ";
		}

		//causing the chat bot to say nothing if told to shut up, will start responding if
		// apologised to
		if(statement.contains(" shut up ")){
			shutUp = true;
		}

		if (shutUp && (statement.contains(" why ") || statement.contains(" talk"))){
			return "I won't talk to you until you say you're sorry";
		} else if (shutUp && (statement.contains("i'm sorry") || statement.contains("im sorry"))){
			shutUp = false;
			return "Thank you, you are forgiven.";
		}
		else if (shutUp){
			return "";
		}
		//initializing response
		String response = "";

		//bot responds to the word "no"
		if (statement.indexOf(" no ") >= 0)
		{
			response = "Why so negative?";
		}
		//bot responds to talking about family members
		else if (statement.indexOf(" mother ") >= 0
				|| statement.indexOf(" father ") >= 0
				|| statement.indexOf(" sister ") >= 0
				|| statement.indexOf(" brother ") >= 0)
		{
			response = "Tell me more about your family.";
		}
		//bot responds to talking about pets
		else if(statement.indexOf(" cat ") >= 0
				|| statement.indexOf(" dog ") >= 0
				|| statement.indexOf(" hamster ") >= 0
				|| statement.indexOf(" fish ") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		//bot responds to talking about mr. smith
		else if(statement.indexOf(" mr. smith ") >= 0)
		{
			response = "I know Mr. Smith. He is a good teacher.";
		}
		//bot responds when asked its name
		else if(statement.indexOf(" your name ") >= 0)
		{
			response = "My name is Simen.";
		}
		//bot responds when someone says "good"
		//so if bot asks how user is it has a response to their answer
		else if(statement.indexOf(" good ") >= 0)
		{
			response = "I'm glad.";
		}
		//bot responds when someone says "bad"
		//so if bot asks how user is it has a response to their answer
		else if(statement.indexOf(" bad ") >= 0)
		{
			response = "I'm sorry you feel that way.";
		}
		//bot responds when someone says "hi"
		else if(statement.indexOf(" hi ") >= 0)
		{
			response = "Hello, how is your day?";
		}
		//bot responds when user says "hello"
		else if(statement.indexOf(" hello ") >= 0)
		{
			response = "Hi, how is your day?";
		}
		//if user says something else, bot will generate a random response
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		//gets a random response by choosing a random number including 0 through 5
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		//random responses:
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if(whichResponse == 4)
		{
			response = "I'm not sure what you are trying to say.";
		}
		else if(whichResponse == 5)
		{
			response = "That's cool!";
		}

		return response;
	}
}
