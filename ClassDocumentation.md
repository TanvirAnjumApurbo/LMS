# Class Documentation

## `Book`

### Fields/Attributes

- `private final String bookID`
- `private String title`
- `private String author`
- `private String publisher`
- `private String category`
- `private int availablePrintedCopies`
- `private int availableEBookCopies`
- `private int availableAudioBookCopies`
- `private double eBookFileSize`
- `private String eBookFormat`
- `private double audioBookDuration`
- `private String audioBookNarrator`

### Constructors & Methods

- `public Book(String bookID, String title, String author, String publisher, String category, int totalPrintedCopies)`
- `public Book(String bookID, String title, String author, String publisher, String category)`
- `public String getBookID()`
- `public String getTitle()`
- `public String getAuthor()`
- `public String getPublisher()`
- `public String getCategory()`
- `void setTitle(String title)`
- `void setAuthor(String author)`
- `void setPublisher(String publisher)`
- `void setCategory(String category)`
- `public int getAvailablePrintedCopies()`
- `public void setAvailablePrintedCopies(int availablePrintedCopies)`
- `public int getAvailableEBookCopies()`
- `public void setAvailableEBookCopies(int availableEBookCopies)`
- `public int getAvailableAudioBookCopies()`
- `public void setAvailableAudioBookCopies(int availableAudioBookCopies)`
- `public double geteBookFileSize()`
- `public void seteBookFileSize(double eBookFileSize)`
- `public String geteBookFormat()`
- `public void seteBookFormat(String eBookFormat)`
- `public double getAudioBookDuration()`
- `public void setAudioBookDuration(double audioBookDuration)`
- `public String getAudioBookNarrator()`
- `public void setAudioBookNarrator(String audioBookNarrator)`
- `public void displayInfo()`
- `public String formatFileSize(double fileSize)`
- `public String formatDuration(double hours)`
- `public boolean isEBookAvailable()`
- `public boolean isAudioBookAvailable()`

## `EBook`

### Fields/Attributes

- `private double fileSize`
- `private String format`

### Constructors & Methods

- `public EBook(String bookID, String title, String author, String publisher, String category, double fileSize, String format)`

- `public double getFileSize()`
- `public void setFileSize(double fileSize)`
- `public String getFormat()`
- `public void setFormat(String format)`
- `private boolean isValidFormat(String format)`

## `AudioBook`

### Fields/Attributes

- `private double duration`
- `private String narrator`

### Constructors & Methods

- `public AudioBook(String bookID, String title, String author, String publisher, String category, double duration, String narrator)`

- `public double getDuration()`
- `public void setDuration(double duration)`
- `public String getNarrator()`
- `public void setNarrator(String narrator)`

## `Library`

### Fields/Attributes

- `private final ArrayList<Book> bookInventory`
- `private final HashMap<String, Member> members`
- `private final List<Transaction> transactions`

### Constructors & Methods

- `public Library()`
- `public void addBook(Book book)`
- `public void removeBook(Book book)`
- `public void updateBook(String bookID)`
- `public void addMember(Member member)`
- `public void removeMember(Member member)`
- `public Book searchBookByTitle(String title)`
- `public boolean borrowBook(Member member, String bookTitle)`
- `public boolean returnBook(Member member, String transactionID)`
- `public void listInventory()`
- `public void listMembers()`
- `public Member getMember(String memberID)`

## `Member`

### Fields/Attributes

- `private final String memberID`
- `private String name`
- `private String contactInfo`
- `private final List<Book> borrowedBooks`

### Constructors & Methods

- `public Member(String memberID, String name, String contactInfo)`
- `public String getMemberID()`
- `public String getName()`
- `public String getContactInfo()`
- `public void setName(String name)`
- `public void setContactInfo(String contactInfo)`
- `public List<Book> getBorrowedBooks()`
- `public void borrowBook(Library library, String bookTitle)`
- `public void returnBook(Library library, String bookTitle)`
- `public void listBorrowedBooks()`

## `Transaction`

### Fields/Attributes

- `private final String transactionID`
- `private final Book book`
- `private final Member member`
- `private final Date borrowDate`
- `private Date returnDate`
- `private String status`
- `private static final SimpleDateFormat dateFormat`

### Constructors & Methods

- `public Transaction(Book book, Member member)`
- `public void logTransaction()`
- `public void completeTransaction()`
- `public String getTransactionID()`
- `public Book getBook()`
- `public Member getMember()`
- `public Date getBorrowDate()`
- `public Date getReturnDate()`
- `public String getStatus()`