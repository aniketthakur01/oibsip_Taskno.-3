import java.util.Scanner;

/**
 * Task3 = ATM machine working procedure
 */

class deposit {
    int depositamt;
    int currentBal;

    deposit(int currentBal) {
        this.currentBal = currentBal;
    }

    deposit() {

    }

    public void setdata() {
        System.out.println("Enter amount you want to deposit");
        Scanner sc = new Scanner(System.in);
        depositamt = sc.nextInt();

        this.currentBal = this.currentBal + depositamt;
        System.out.println("Now Current balance after deposit is: " + this.currentBal);

    }

}

class withdraw extends deposit {
    int withdrawamt;

    withdraw(deposit depo) {
        this.currentBal = depo.currentBal;
    }

    withdraw() {
    }

    public void setdata() {
        System.out.println("Enter the amount you want to withdraw");
        Scanner sc = new Scanner(System.in);
        withdrawamt = sc.nextInt();

        System.out.println(this.currentBal);

        this.currentBal = this.currentBal - withdrawamt;
        System.out.println("Now Current balance after withdraw is: " + this.currentBal);
    }
}

class transfer extends withdraw {
    int transferamt;

    transfer(withdraw with) {
        this.currentBal = with.currentBal;
    }

    transfer() {
    }

    public void setdata() {

        System.out.println("Enter the amount you want to transfer");
        Scanner sc = new Scanner(System.in);
        transferamt = sc.nextInt();

        this.currentBal = this.currentBal - transferamt;
        System.out.println("Now Current balance after transfer is: " + this.currentBal);

    }
}

class txnHistory extends transfer {
    
    txnHistory(transfer tran) {
        super.transferamt = tran.transferamt;
    }

    public void setdata() {
        System.out.println("the transaction history is: " + super.transferamt);
    }
}

class quit {
    int userquit;

    public void quittxn() {
        System.out.println("User Want to quit/end transaction: Enter '1' >>>> else Enter '0' ");
        Scanner s = new Scanner(System.in);
        userquit = s.nextInt();

        if (userquit == 1) {
            System.out.println("Transaction End");
            System.out.println("Thankyou for BANKING WITH US");
        }
        // break;
    }
}

public class Task3 {

    public static void main(String[] args) {
        String name;
        int pincode;
        int password;
        // int currentBal = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to INDIAN BANK");
        System.out.println("Accoutn Holder Name");
        name = scan.nextLine();
        System.out.println("");

        System.out.println("Enter the USER ID ");
        pincode = scan.nextInt();
        System.out.println("");

        System.out.println("Enter the PIN CODE ");
        password = scan.nextInt();
        System.out.println("");
        System.out.println("WELCOME " + name);
        System.out.println("");

        deposit depo = new deposit(10000);
        depo.setdata();

        withdraw with = new withdraw(depo);
        with.setdata();

        transfer tran = new transfer(with);
        tran.setdata();

        txnHistory trhis = new txnHistory(tran);
        trhis.setdata();

        quit q = new quit();
        q.quittxn();

    }
}
