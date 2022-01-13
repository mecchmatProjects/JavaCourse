import java.text.SimpleDateFormat;
import java.util.*;

final class CommentUtils {
    /**
     * An example string that fits the format "15-03-2020 10:20:34".
     * Use it to print the comments.
     */
    public static final SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private CommentUtils() { }

    /**
     * It processes a given list of comments by removing old comments and shortening the text length
	handleComments to process a given list of comments by removing old ones (older than thresholdDate) and shortening exceeding texts 	(i.e., longer than maxTextLength)
     */
    public static void handleComments(List<Comment> comments, Date thresholdDate, int maxTextLength) {
        // write your code here
	comments.removeIf((word) -> word.getCreated().before(thresholdDate));
	comments.replaceAll((word)-> {return new Comment(word.getCreated(), 
						word.getText().substring(0, Math.min(word.getText().length(), maxTextLength)));});
	
    }

    /**
     * It prints each comment in the following format:
     * [14-03-2020 10:20:34] What a beautiful photo! Where is it?
     * [16-03-2020 15:35:18] I do not know, I just found it on the internet!
     * [20-03-2020 19:10:22] Is anyone here?
     * Please, use the formatter above to fit the format.
     */
    public static void printComments(List<Comment> comments) {
        // write your code here
	/*comments.forEach((x)->{
		String date = TEXT_FORMATTER.format(x.getCreated());
		System.out.print("[" + date +"] ");
		System.out.println(x.getText());
		});*/
	
	comments.forEach(c -> {
            synchronized (TEXT_FORMATTER) {
                System.out.println("[" + TEXT_FORMATTER.format(c.getCreated()) + "] " + c.getText());
            }
        });

    }
}

class Comment {
    private final Date created;
    private final String text;

    public Comment(Date created, String text) {
        this.created = created;
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public String getText() {
        return text;
    }
}

public class CommentProcess{

	public static void main(String args[]) {
		try{
		List<Comment> comments = new ArrayList<>();

		comments.add(new Comment(
		        CommentUtils.TEXT_FORMATTER.parse("14-03-2020 10:20:34"),
        				"What a beautiful photo! Where is it?"
		));
		
		comments.add(new Comment(
        		CommentUtils.TEXT_FORMATTER.parse("16-03-2020 15:35:18"),
        				"I do not know, I just found it on the internet!"
		));
		comments.add(new Comment(
        		CommentUtils.TEXT_FORMATTER.parse("20-03-2020 19:10:22"),
        			"Is anyone here?"
		));
        
		Date threshold = CommentUtils.TEXT_FORMATTER.parse("15-03-2020 00:00:00");
		int maxTextLength = 30; // it is just an example, do not rely on this number!
        
		CommentUtils.handleComments(comments, threshold, maxTextLength);
		CommentUtils.printComments(comments);	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
