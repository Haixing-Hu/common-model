////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import ltd.qubit.commons.util.transformer.Transformer;
import ltd.qubit.model.settlement.Transaction;

public class PaymentRequestTransformer implements
        Transformer<Transaction> {

  @Override
  public Transaction transform(final Transaction transaction) {
    if (transaction != null) {
      transaction.setType(null);
      transaction.setOriginId(null);
      transaction.setReturnId(null);
      transaction.setStatus(null);
      transaction.setApp(null);
      transaction.setSource(null);
      transaction.setCategory(null);
      transaction.setDiscount(null);
      transaction.setPaid(null);
      transaction.setPayee(null);
      transaction.setPayment(null);
      transaction.setCompleteTime(null);
      transaction.setInvoiceStatus(null);
      transaction.setComment(null);
      transaction.setEnvironment(null);
      transaction.setModifyTime(null);
      transaction.setDeleteTime(null);
      final Participant payer = transaction.getPayer();
      if (payer != null) {
        payer.setId(null);
        payer.setType(null);
        payer.setPhone(null);
        payer.setEmail(null);
        payer.setAccount(null);
      }
    }
    return transaction;
  }
}
