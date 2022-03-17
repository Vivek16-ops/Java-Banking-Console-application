import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface bank {
    String getNumber();

    void setNumber(String number);

    double getBalance();

    void setBalance(double balance);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

}

interface process {
    void DepositMoney(double DepositedMoney);

    void WithDrawMoney(double WithdrawalMoney);

}

class Account implements bank, process {
    private String Number;
    private double Balance;
    private String Name;
    private String Email;
    private String PhoneNumber;

    public void DepositMoney(double DepositedMoney) {
        this.Balance += DepositedMoney;
        System.out.println("Deposit is Successful, Your Balance is " + this.Balance);
    }

    public void WithDrawMoney(double WithdrawalMoney) {
        if (this.Balance - WithdrawalMoney < 0) {
            System.out.println("WithDraw Unseccessful only " + this.Balance + " is left");
        } else {
            this.Balance -= WithdrawalMoney;
            System.out.println("Withdraw successful, Current Balance is " + this.Balance);
        }
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}

class abc {
    static int flag;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of Customer");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br1.readLine());

        Account ob[] = new Account[r];

        for (int i = 0; i < r; i++) {
            ob[i] = new Account();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("*****//Banking Console Apllication//*****");
            System.out.println("          By Vivek Raj ");
            System.out.println(" ");
            System.out.println(" 1) Enter Customer Detail");
            System.out.println(" 2) Deposite Money");
            System.out.println(" 3) Check Acount Details");
            System.out.println(" 4) Exit");

            int ch = Integer.parseInt(br.readLine());
            switch (ch) {

                case 1:
                    System.out.println("Enter Customer Account Number");
                    String s = br.readLine();
                    ob[i].setNumber(s);
                    System.out.println("Enter Customer Name");
                    String s1 = br.readLine();
                    ob[i].setName(s1);
                    System.out.println("Enter Customer Email");
                    String s2 = br.readLine();
                    ob[i].setEmail(s2);
                    System.out.println("Enter Customer Phone No");
                    String s3 = br.readLine();
                    ob[i].setPhoneNumber(s3);
                    flag = 1;

                case 2:
                    if (flag == 1) {
                        System.out.println("Enter the Amount to be deposite");
                        double d1 = Double.parseDouble(br.readLine());
                        ob[i].DepositMoney(d1);

                    } else {

                    }

                case 3:
                    if (flag == 1) {
                        System.out.println("Customer Account number is " + ob[i].getNumber());
                        System.out.println("Customer Account Balance is " + ob[i].getBalance());
                        System.out.println("Customer Name is " + ob[i].getName());
                        System.out.println("Customer Email Id is " + ob[i].getEmail());
                        System.out.println("Customer Phone number is " + ob[i].getPhoneNumber());
                        break;
                    } else {
                        System.out.println("Customer Datails not entered");
                    }
                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong choice");
                    System.exit(0);
            }
            System.out.println(" ");
        }
        System.out.println("Do you want to make any changes Press 1");
        int c = Integer.parseInt(br1.readLine());
        if (c == 1) {
            System.out.println("In which Customer do you want to make changes");
            int a = Integer.parseInt(br1.readLine());
            a = a - 1;
            if (a >= 0 || a <= r--) {
                while (true) {
                    int ch;
                    double d, e;
                    System.out.println("Changement Tab");
                    System.out.println(" 1) Deposite Money ");
                    System.out.println(" 2) Withdraw");
                    System.out.println(" 3) Exit");
                    System.out.println("Enter Your Choice");

                    ch = Integer.parseInt(br1.readLine());
                    switch (ch) {
                        case 1:
                            System.out.println("Enter Amount to be Deposited");
                            d = Double.parseDouble(br1.readLine());
                            ob[a].DepositMoney(d);
                            break;
                        case 2:
                            System.out.println("Enter Withdrawal Amount");
                            e = Double.parseDouble(br1.readLine());
                            ob[a].WithDrawMoney(e);
                            break;
                        case 3:
                            System.exit(0);
                    }
                }
            } else {
                System.out.println("Wrong choice");
            }

        }

    }

}