package com.ay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.dao.BookingFormCrud;
import com.ay.model.BookingForm;

@Service
public class BookingFormServiceImpl implements BookingFormService {
	
	
	private BookingFormCrud bookingFormCrud;
	
	@Autowired
	public void setBookingFormCrud(BookingFormCrud bookingFormCrud) {
		this.bookingFormCrud = bookingFormCrud;
	}

   

	@Override
	public BookingForm saveBookingFormService(BookingForm bookingForm) {
		// TODO Auto-generated method stub
		
	return bookingFormCrud.save(bookingForm);
		
		
	}

}
