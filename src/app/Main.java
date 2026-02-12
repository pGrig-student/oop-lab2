package app;

import book.Book;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[5];

        books[0] = new Book(1, "Кобзар", "Шевченко Т.Г.", "Дніпро", 1985, 400, 150.00);
        books[1] = new Book(2, "Тіні забутих предків", "Коцюбинський М.М.", "А-ба-ба-га-ла-ма-га", 2015, 120, 200.50);
        books[2] = new Book(3, "Захар Беркут", "Франко І.Я.", "Дніпро", 1990, 250, 80.00);
        books[3] = new Book(4, "Гайдамаки", "Шевченко Т.Г.", "Основа", 2005, 180, 120.00);
        books[4] = new Book(5, "Java. Ефективне програмування", "Джошуа Блох", "Addison-Wesley", 2019, 450, 1200.00);
        run(books);
    }

    public static Book[] getBooksByAuthor(Book[] books, String author) {
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equals(author)) {
                books[counter] = books[i];
                counter++;
            }
        }
        return Arrays.copyOf(books, counter);
    }

    public static Book[] getBooksByPublisher(Book[] books, String publisher) {
        int counter = 0;
        Book[] books2 = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublisher().equals(publisher)) {
                books2[counter] = books[i];
                counter++;
            }
        }
        return Arrays.copyOf(books2, counter);
    }

    public static Book[] getBooksByYearAndPages(Book[] books, int year, int pages) {
        int count = 0;
        Book[] booksByYearAndPages = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i].getYear() < year && books[i].getPageCount() > pages) {
                booksByYearAndPages[count] = books[i];
                count++;
            }
        }
        return Arrays.copyOf(booksByYearAndPages, count);
    }

    public static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    public static void run(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- ГОЛОВНЕ МЕНЮ ---");
            System.out.println("1. Знайти книги за автором");
            System.out.println("2. Знайти книги за видавництвом");
            System.out.println("3. Знайти книги (до року X та > Y сторінок)");
            System.out.println("4. Показати всі книги");
            System.out.println("0. Вихід");
            System.out.print("Введіть номер дії: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Введіть ім'я автора: ");
                        String author = scanner.nextLine();
                        Book[] booksByAuthor = getBooksByAuthor(books, author);
                        printBooks(booksByAuthor);
                        break;
                    case 2:
                        System.out.print("Введіть назву видавництва: ");
                        String publisher = scanner.nextLine();
                        Book[] booksByPublisher = getBooksByPublisher(books, publisher);
                        printBooks(booksByPublisher);
                        break;
                    case 3:
                        System.out.print("Введіть граничний рік: ");
                        int year = scanner.nextInt();
                        System.out.print("Введіть мінімальну к-сть сторінок: ");
                        int pages = scanner.nextInt();
                        Book[] booksByYearAndPages = getBooksByYearAndPages(books, year, pages);
                        printBooks(booksByYearAndPages);
                        break;
                    case 4:
                        for (Book b : books) System.out.println(b);
                        break;
                    case 0:
                        System.out.println("Роботу завершено.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            } else {
                System.out.println("Будь ласка, введіть число.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
