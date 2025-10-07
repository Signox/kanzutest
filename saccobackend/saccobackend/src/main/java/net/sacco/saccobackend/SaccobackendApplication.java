package net.sacco.saccobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sacco.saccobackend.model.Approvals;
import net.sacco.saccobackend.model.PaymentType;
import net.sacco.saccobackend.model.Requests;
import net.sacco.saccobackend.repository.RequestRepository;
import net.sacco.saccobackend.repository.ApprovalRepository; 

@SpringBootApplication
public class SaccobackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SaccobackendApplication.class, args);
    }

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ApprovalRepository approvalsRepository;

    @Override
    public void run(String... args) throws Exception {

        // Check if Approvals table is empty-indicates that no mock data is save dyet
        if (approvalsRepository.count() == 0) {
            // Insert sample Requests
            Requests request1 = new Requests();
            request1.setMember("John Doe");
            request1.setAmount(1000.0f);
            request1.setStatus("pending");
            request1.setApproval(0);
            request1.setPaymentType(PaymentType.MOBILE_MONEY);
            request1.setRequiredApprovals(2);

            Requests request2 = new Requests();
            request2.setMember("Paul Doe");
            request2.setAmount(3000.0f);
            request2.setStatus("pending");
            request2.setApproval(1);
            request2.setPaymentType(PaymentType.CHEQUE);
            request2.setRequiredApprovals(2);

            Requests request3 = new Requests();
            request3.setMember("Jane Doe");
            request3.setAmount(4000.0f);
            request3.setStatus("pending");
            request3.setApproval(0);
            request3.setPaymentType(PaymentType.BANK_TRANSFER);
            request3.setRequiredApprovals(2);

            Requests request4 = new Requests();
            request4.setMember("Dora Doe");
            request4.setAmount(1000.0f);
            request4.setStatus("pending");
            request4.setApproval(2);
            request4.setPaymentType(PaymentType.MOBILE_MONEY);
            request4.setRequiredApprovals(2);

            Requests request5 = new Requests();
            request5.setMember("Mercy Doe");
            request5.setAmount(3000.0f);
            request5.setStatus("pending");
            request5.setApproval(2);
            request5.setPaymentType(PaymentType.MOBILE_MONEY);
            request5.setRequiredApprovals(2);

            Requests request6 = new Requests();
            request6.setMember("Jane Baool");
            request6.setAmount(4000.0f);
            request6.setStatus("pending");
            request6.setApproval(1);
            request6.setPaymentType(PaymentType.MOBILE_MONEY);
            request6.setRequiredApprovals(2);

            Approvals approval = new Approvals();
            approval.setMaxcount(2);

            requestRepository.save(request1);
            requestRepository.save(request2);
            requestRepository.save(request3);
            approvalsRepository.save(approval);        

        }
    }
}