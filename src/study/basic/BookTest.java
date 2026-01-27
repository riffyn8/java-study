package study.basic;

class Book{
    // 1. 데이터 무결성을 위해 외부 직접 접근을 제한 (캡슐화)
    private String isbn;
    private String title;
    private String author;
    private int price;
    private boolean isBorrowed;

    // 2. 객체 생성 시 필수 상태 값을 강제하고 유효성을 보장
    public Book(String isbn, String title, String author, int price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        setPrice(price);
        this.isBorrowed = false;
    }

    // 3. Getter: 내부 데이터를 안전하게 읽기 전용으로 노출
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // 4. Setter: 단순 변경이 아닌, 비즈니스 규칙을 적용하여 필터링
    // 가격 변동이 없다고 가정하면 private를 사용해 생성자 내에서만 초기화 가능하게 한다.
    // 가격 변동이 필요하다면 public을 사용하여 외부에서도 수정할 수 있게 한다.
    public void setPrice(int price) {
        if(price < 0) {
            System.out.println("가격은 0 이상이어야 합니다.");
            return;
        }
        this.price = price;
    }

    public boolean borrow() {
        if(isBorrowed) {
            System.out.println("이미 대출 중인 도서입니다.");
            return false;
        }

        isBorrowed = true;
        System.out.println("『 " + title + "』 대출 완료");
        return true;
    }

    public void returnBook() {
        if(!isBorrowed) {
            System.out.println("대출 중이 아닌 도서입니다.");
            return;
        }

        isBorrowed = false;
        System.out.println("『 " + title + "』 반납 완료");
    }

    public void showInfo() {
        System.out.println("=== 도서 정보 ====");
        System.out.println("ISBN:" + isbn);
        System.out.println("제목:" + title);
        System.out.println("저자:" + author);
        System.out.println("가격:" + price + "원");
        System.out.println("상태:" + (isBorrowed ? "대출중" : "대출가능"));
    }

}

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("9788994492001", "자바의 정석", "남궁성", 36000);

        book.borrow();
        book.showInfo();

        System.out.println();

        book.returnBook();
        book.showInfo();
    }
}
