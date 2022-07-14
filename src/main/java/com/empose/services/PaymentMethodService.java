package com.empose.services;

import com.empose.models.Client;
import com.empose.models.PaymentMethods;
import com.empose.repositories.ClientRepository;
import com.empose.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public Optional<PaymentMethods> findById(Integer id) {
        return paymentMethodRepository.findById(id);
    }

    public List<PaymentMethods> findAll() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethods save(PaymentMethods paymentMethod) {
        Optional<PaymentMethods> optClient = paymentMethodRepository.findByName(paymentMethod.getName());
        if (!optClient.isPresent()) {
            return paymentMethodRepository.save(paymentMethod);
        }
        return new PaymentMethods();
    }

    public PaymentMethods update(PaymentMethods paymentMethod) {
        Optional<PaymentMethods> optPayment = paymentMethodRepository.findById(paymentMethod.getId());
        PaymentMethods paymentMethodtUpdate = new PaymentMethods();

        if (optPayment.isPresent()) {
            paymentMethodtUpdate = paymentMethodRepository.save(paymentMethod);
        }

        return paymentMethodtUpdate;
    }

    public String remove(PaymentMethods paymentMethod) {
        Optional<PaymentMethods> optPayment = paymentMethodRepository.findById(paymentMethod.getId());

        if (optPayment.isPresent()) {
            paymentMethodRepository.delete(paymentMethod);
                return "";
            } else {
                return "Metodo de pagamento não pode ser removido.";
            }
    }
}
