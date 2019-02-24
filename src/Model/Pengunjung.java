package Model;

public class Pengunjung {
    private int ticketID;
    private int status;

    public Pengunjung(int ticketNo, int status) {
        this.ticketID = ticketNo;
        if (status == 1 || status == 2 || status == 3) {
            this.status = status;
        } else {
            this.status = 0;
        }
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status == 1 || status == 2 || status == 3) {
            this.status = status;
            System.out.println(viewStatus(this.status));
        } else {
            System.out.println("Status invalid!");
            this.status = 0;
            System.out.println(viewStatus(this.status));
        }
    }
    
    public String viewStatus(int status) {
        switch (status) {
            case 1:
                return("Regular Visitor");
            case 2:
                return("VIP Visitor");
            case 3:
                return("Promo Visitor");
            default:
                return("Status not set");
        }
    }
}
