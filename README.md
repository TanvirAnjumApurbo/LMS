# 📚 Library Management System

---

This Library Management System (LMS) is a Java-based application designed to manage books, members, and transactions in a library. It supports various book formats including printed books, eBooks, and audiobooks. The system allows for adding, removing, and updating books and members, as well as borrowing and returning books.

## 🗃️ Features

---

- 📚 **Manage Books**: Add, remove, search, and list books in the library's inventory.
- 🧑‍🤝‍🧑 **Member Management**: Add and remove members, and keep track of their borrowing history.
- 🔄 **Borrow & Return Books**: Easily borrow and return books with real-time updates to availability.
- 🔍 **Search Books**: Search for books by title and view details like author, category, and available copies.
- 📝 **Update Book Details**: Modify book format and availability.


## 📂 Project Structure

---

- `src/com/library/AudioBook.java`: Defines the `AudioBook` class, extending the `Book` class with additional attributes for duration and narrator.
- `src/com/library/Book.java`: Defines the `Book` class, the base class for all book types.
- `src/com/library/EBook.java`: Defines the `EBook` class, extending the `Book` class with additional attributes for file size and format.
- `src/com/library/LMS.java`: The main class that runs the Library Management System.
- `src/com/library/Library.java`: Manages the collection of books and members, and handles borrowing and returning books.
- `src/com/library/Member.java`: Defines the `Member` class, representing a library member.
- `src/com/library/Transaction.java`: Defines the `Transaction` class, representing a borrowing transaction.

...
<br>
<br>
`The project is still in progress, and more features will be added as they are completed.`
<br>

## 🚀 Getting Started

---

[![Getting Started](https://img.shields.io/badge/Getting_Started-Ready-red)](https://github.com/TanvirAnjumApurbo/LMS.git)

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA or any other Java IDE

### Running the Application

1. Clone the repository:
    ```sh
    git clone https://github.com/TanvirAnjumApurbo/LMS.git
    ```
2. Open the project in IntelliJ IDEA.
3. Navigate to the `src/com/library/LMS.java` file.
4. Run the `LMS` class.

### Usage

1. **Add Book**: Enter book details including ID, title, author, publisher, category, and format (Printed/EBook/AudioBook).
2. **Remove Book**: Enter the title of the book to remove.
3. **Add Member**: Enter member details including ID, name, and contact information.
4. **Remove Member**: Enter the ID of the member to remove.
5. **Borrow Book**: Enter the member ID and the title of the book to borrow.
6. **Return Book**: Enter the member ID and the transaction ID to return the book.
7. **Search Book by Title**: Enter the title of the book to search.
8. **Display All Books**: Lists all books in the library.
9. **Update Book**: Enter the book ID and update the book details.

## 🤝 Contribution

---

![Contributions](https://img.shields.io/badge/Contributions-Welcome-brightgreen.svg)

Contributions are welcome! Please feel free to fork this repository, make changes, and submit a pull request. Whether it's improving documentation, fixing bugs, or adding something new, your help is appreciated.

## 📄 License

---

![License](https://img.shields.io/badge/License-MIT-green.svg)

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for more details.

## 🔗 Connect with Me

---

![Connect with Me](https://img.shields.io/badge/Connect-with%20Tanvir-%23007bff)

Feel free to connect with me on [LinkedIn](https://www.linkedin.com/in/tanvir-anjum-apurbo-2a8b1620b/). I’m always open to discussing new opportunities, collaborations, and programming!

### Happy coding! 🚀

![Made with Java](https://img.shields.io/badge/Made%20with-Java-brown.svg)