package datastructure.linked;

// 연결 리스트의 노드
class ListNode{
    private String data;    // 데이터 필드
    public ListNode link;   // 링크 필드

    public ListNode() {
        this.data = null;
        this.link = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

class LinkedList {
    private ListNode head; // 리스트의 시작 주소

    public LinkedList() {
        this.head = null;
    }

    // 중간 노드로 삽입하기
    // pre : 선행자 노드(이 노드 뒤에 삽입 됨.
    // data : 삽입할 데이터
    public void insertMiddleNode(ListNode pre, String data) {
        // 1. 새 노드 생성 (자유 공간 리스트로부터 할당)
        ListNode newNode = new ListNode(data);

        // 2. 새 노드가 기존 pre의 다음 노드를 가리키게 함 (연결 고리 유지)
        // 예: A(100, 200) → B(200, null) 중간에 C를 삽입 할 경우 A(100, 300) → C(300, 200) → B(200, null)
        newNode.link = pre.link;

        // 3. 선행자 노드(pre)가 새 노드를 가리키도록 설정 (삽입 완료)
        pre.link = newNode;
    }

    // 마지막 노드로 삽입하기
    public void insertLastNode(String data) {
        ListNode newNode = new ListNode(data);

        // 리스트가 비어 있으면 head로 지정하고 종료
        if(head == null) {
            this.head = newNode;
        } else {
            // 마지막 노드를 찾기 위한 임시 포인터 temp
            ListNode temp = head;

            // temp.link가 null이면 현재 노드가 '마지막 노드'임을 의미
            while(temp.link != null) {
                temp = temp.link;
                /* 순회 원리 : A(link:200) → B(link:300) → C(link:null)
                    1. temp가 A일 때 link(200)가 null이 아니므로 temp는 B가 됨
                    2. temp가 B일 때 link(300)가 null이 아니므로 temp는 C가 됨
                    3. temp가 C일 때 link가 null이므로 반복 종료 (마지막 노드 C 확보)
                */
            }

            // 찾은 마지막 노드의 link에 새 노드 주소를 저장하여 연결
            temp.link = newNode;
        }
    }

    // 마지막 노드 삭제하기
    public void deleteLastNode() {
        ListNode pre, temp;

        if(head == null) return;

        if(head.link == null) {
            head = null;
        } else {
            // 마지막 노드(temp)와 그 바로 앞 노드(pre)를 동시에 찾아야 함
            pre = head;
            temp = head.link;

            while(temp.link != null) {
                pre = temp;         // temp가 가기 전 위치를 pre가 지킴
                temp = temp.link;   // temp는 한 칸 앞으로 이동
            }
            // 반복 종료 시 : pre는 마지막 앞 노드, temp는 실제 마지막 노드

            // 마지막 앞 노드의 연결을 끊어(null) 마지막 노드를 삭제. pre가 마지막 노드가 됨
            pre.link = null;
        }

    }

    public ListNode searchNode(String data) {
        ListNode temp = this.head;
        while(temp != null) {
            if(data == temp.getData())
                return temp;
            else
                temp = temp.link;
        }
        return temp;
    }

    public void reverseList() {
        ListNode next = head;
        ListNode current = null;
        ListNode pre = null;
        while(next != null) {
            pre = current;
            current = next;
            next = next.link;
            current.link = pre;
        }
        head = current;
    }

    public void printList() {
        ListNode temp = this.head;
        System.out.printf("L = (");

        while(temp != null) {
            System.out.print(temp.getData());
            temp = temp.link;
            if(temp != null) {
                System.out.print(", ");
            }
        }

        System.out.println(")");
    }

    // ----------- 직접 구현해보기 -----------
    
    // 첫 번째 노드로 삽입하기
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);
        newNode.link = this.head;   // 새 노드가 기존의 첫 노드를 가리키게 함
        this.head = newNode;        // 리스트의 시작 주소를 새 노드로 업데이트!
    }

    // 노드가 어디에 있던지 삭제하기
    public void deleteNode(String data) {
        if(head == null) return;

        // 1. 삭제할 노드가 첫 번째 노드인 경우
        if(head.getData().equals(data)) {
            head = head.link;
            return;
        }

        // A(100,200), B(200,300), C(300,400), D(400,null)가 있을 때 B를 삭제하려고 하면
        // A를 찾아야 함. 그리고 A의 링크필드 값에 B 링크 필드값 (300)이 A의 링크필드 값으로 바뀌어야함.
        // 마지막 노드까지 순회하면서, data와 일치하는 것을 찾음 (이때, pre.link.getData() 하는 이유는
        // 위에서 첫 번째 노드삭제하는 경우 처리르 했기 때문에 첫번째 노드 다음이라는것이 명확하기 때문
        // 일치하는 것을 찾으면 a의 링크 필드에 b(pre.link.link 했기 때문에 a.link의 link 즉, C를 가리킴) 의 링크 필드 값 저장
        // 값 일치하는 것이 없으면 다음 노드로 넘어감


        ListNode pre = head;
        // 2. 삭제할 노드의 선행자(pre)를 찾기 위해 순회
        // 이때, 위에서 첫 번째 노드가 삭제에 대한 예외처리를 했으므로 '두 번째 노드'부터 검사하는 것
        while(pre.link != null) {
            // pre.link.getData()는 '삭제 후보'의 데이터를 확인하는 것
            if(pre.link.getData().equals(data)) {
                // 일치하는 노드 발견 시 pre의 링크 필드에서 삭제 노드의 링크 필드값을 저장
                /* 예:
                 A(100,200) - B(200,300) - C(300,400) - D(400,null) 에서 B를 삭제할 경우
                 1. A.link 즉, B의 데이터를 확인
                 2. pre.link = pre.link.link 는 A.link(200) = A.link.link(300)
                 3. 결과적으로는 A는 B를 건너뛰고 C를 직접 가리키게 됨
                 */
                pre.link = pre.link.link;
                return;
            }
            // 일치하는 데이터가 없으면 다음 노드로 이동하여 계속 탐색
            pre = pre.link;
        }
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList L = new LinkedList();

        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        L.insertLastNode("월");
        L.insertLastNode("수");
        L.insertLastNode("일");
        L.printList();

        System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
        ListNode pre = L.searchNode("수");
        if(pre == null)
            System.out.println("fail) 찾는 데이터가 없습니다.");
        else {
            L.insertMiddleNode(pre, "금");
            L.printList();
        }

        System.out.println("(3) 리스트의 노드를 역순으로 바꾸기");
        L.reverseList();
        L.printList();

        System.out.println("(4) 리스트의 마지막 노드 삭제하기");
        L.deleteLastNode();
        L.printList();

        System.out.println("(추가) 맨 앞에 노드 삽입 구현");
        L.insertNode("토");
        L.printList();

        System.out.println("(추가) 어디에 있던지 노드 삭제");
        L.deleteNode("금");
        L.printList();

    }
}

