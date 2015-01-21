public class TestBook {

	public static void main(String[] args) {
		Author anAuthor = new Author("John Schmieder", "jschmieder@mail.com", 'm');
		Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
		Book anotherBook = new Book("more Java for dummy", new Author("Joe Schmieder", "joeschmieder@mail.com", 'm'), 29.95, 888);

		System.out.println("Name of the author	: " + aBook.getAuthor().getName());
		System.out.println("Email of the author	: " + aBook.getAuthor().getEmail());

		System.out.println("Name of the author	: " + anotherBook.getAuthorName());
		System.out.println("Email of the author	: " + anotherBook.getAuthorEmail());
		System.out.println("Gender of the author: " + anotherBook.getAuthorGender());
	}

}
