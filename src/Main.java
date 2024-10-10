import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Phone> phoneList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI-----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự để loại bỏ dòng mới

            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    viewPhoneList();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 5);
    }

    private static void addPhone() {
        System.out.print("Nhập loại điện thoại (1: Chính hãng, 2: Xách tay): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự mới để loại bỏ dòng mới

        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự mới

        System.out.print("Nhập tên điện thoại: ");
        String name = scanner.nextLine();

        double price;
        do {
            System.out.print("Nhập giá bán (phải là số dương): ");
            price = scanner.nextDouble();
            if (price <= 0) {
                System.out.println("Giá bán phải là số dương. Vui lòng nhập lại.");
            }
        } while (price <= 0); // Giá bán phải là số dương

        int quantity;
        do {
            System.out.print("Nhập số lượng: ");
            quantity = scanner.nextInt();
            if (quantity < 0) {
                System.out.println("Số lượng không được âm. Vui lòng nhập lại.");
            }
        } while (quantity < 0); // Số lượng không được âm

        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();

        if (type == 1) { // Điện thoại chính hãng
            int warrantyPeriod;
            do {
                System.out.print("Nhập thời gian bảo hành (ngày, không quá 730 ngày): ");
                warrantyPeriod = scanner.nextInt();
                if (warrantyPeriod > 730) {
                    System.out.println("Thời gian bảo hành không được quá 730 ngày. Vui lòng nhập lại.");
                }
            } while (warrantyPeriod > 730); // Thời gian bảo hành không quá 730 ngày

            String warrantyScope;
            do {
                System.out.print("Nhập phạm vi bảo hành (toan quoc/quoc te): ");
                warrantyScope = scanner.nextLine().toLowerCase();
                if (!warrantyScope.equals("toan quoc") && !warrantyScope.equals("quoc te")) {
                    System.out.println("Phạm vi bảo hành không hợp lệ. Vui lòng nhập lại.");
                }
            } while (!warrantyScope.equals("toan quoc") && !warrantyScope.equals("quoc te")); // Phạm vi bảo hành hợp lệ

            phoneList.add(new NewPhone(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope));
        } else if (type == 2) { // Điện thoại xách tay
            String importCountry;
            do {
                System.out.print("Nhập quốc gia xách tay (không được là Viet Nam): ");
                importCountry = scanner.nextLine();
                if (importCountry.equalsIgnoreCase("Viet Nam")) {
                    System.out.println("Quốc gia xách tay không được là Viet Nam. Vui lòng nhập lại.");
                }
            } while (importCountry.equalsIgnoreCase("Viet Nam")); // Quốc gia xách tay không được là Việt Nam

            String condition;
            do {
                System.out.print("Nhập trạng thái (da sua chua/chua sua chua): ");
                condition = scanner.nextLine().toLowerCase();
                if (!condition.equals("da sua chua") && !condition.equals("chua sua chua")) {
                    System.out.println("Trạng thái không hợp lệ. Vui lòng nhập lại.");
                }
            } while (!condition.equals("da sua chua") && !condition.equals("chua sua chua")); // Trạng thái hợp lệ

            phoneList.add(new UsedPhone(id, name, price, quantity, manufacturer, importCountry, condition));
        } else {
            System.out.println("Loại điện thoại không hợp lệ.");
        }
        System.out.println("Điện thoại đã được thêm vào danh sách.");
    }

    private static void deletePhone() {
        System.out.print("Nhập ID điện thoại cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự mới

        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getId() == id) {
                phoneList.remove(i);
                System.out.println("Điện thoại đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy điện thoại với ID: " + id);
    }

    private static void viewPhoneList() {
        System.out.println("Danh sách điện thoại:");
        for (Phone phone : phoneList) {
            phone.displayInfo();
            System.out.println();
        }
    }

    private static void searchPhone() {
        System.out.print("Nhập tên điện thoại cần tìm: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Phone phone : phoneList) {
            if (phone.getName().equalsIgnoreCase(name)) {
                phone.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy điện thoại với tên: " + name);
        }
    }
}
