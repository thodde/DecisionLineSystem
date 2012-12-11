package controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import view.AdminForm;
import view.CreateEventForm;
import view.CredentialsForm;
import view.MainForm;

import model.Model;
import junit.framework.TestCase;

public class TestButtonController extends TestCase {
	public void testButtonController() {
		ButtonController bc0 = new ButtonController(0, new JFrame());
		ButtonController bc2 = new ButtonController(2, new JFrame());
		ButtonController bc3 = new ButtonController(3, new JFrame());
		
		bc0.loadCredentialsForm(Model.getModel().getDecisionLinesEvent().getEventID());
		bc0.loadAdminForm();
		bc0.setupEventOptions();
		
		bc0.actionPerformed(new ActionEvent(this, 0, "test"));
		bc2.actionPerformed(new ActionEvent(this, 2, "test"));
	}

	
	public void testButtonControllerModerator() {

		CreateEventForm cef = null;
		CredentialsForm cf = null;
		AdminForm af = null;

		ButtonController bc = new ButtonController(ButtonController.MODERATOR_BUTTON_VALUE, new JFrame());

		bc.actionPerformed(new ActionEvent(this, 0, "testModerator"));

		// moderator button  creates CreateEventForm
		cef = bc.getCreateEventForm();
		assertNotNull(cef);
		assertTrue(cef.isVisible());

		// all other forms remain null
		cf = bc.getCredentialsForm();
		assertNull(cf);

		af = bc.getAdminForm();
		assertNull(af);

		// now tear down all and refresh forms, all should be null
		bc.tearDownForms();

		cef = bc.getCreateEventForm();
		assertNull(cef);

		cf = bc.getCredentialsForm();
		assertNull(cf);

		af = bc.getAdminForm();
		assertNull(af);
	}

	
	public void testButtonControllerUser() {

		CreateEventForm cef = null;
		CredentialsForm cf = null;
		AdminForm af = null;
		Model m = Model.getModel();
        MainForm mf = new MainForm(m);
        mf.setTextField("1234");
        
		ButtonController bc = new ButtonController(ButtonController.USER_BUTTON_VALUE, mf);

		bc.actionPerformed(new ActionEvent(this, 0, "testUser"));

		// user button  creates visible CredentialsForm
		cf = bc.getCredentialsForm();
		assertNotNull(cf);
		assertTrue(cf.isVisible());

		// all other forms remain null
		cef = bc.getCreateEventForm();
		assertNull(cef);

		
		af = bc.getAdminForm();
		assertNull(af);

		// now tear down all and refresh forms, all should be null
		bc.tearDownForms();

		cef = bc.getCreateEventForm();
		assertNull(cef);

		cf = bc.getCredentialsForm();
		assertNull(cf);

		af = bc.getAdminForm();
		assertNull(af);
	}
	
	public void testButtonControllerAdmin() {

		CreateEventForm cef = null;
		CredentialsForm cf = null;
		AdminForm af = null;

		ButtonController bc = new ButtonController(ButtonController.ADMIN_BUTTON_VALUE, new JFrame());

		bc.actionPerformed(new ActionEvent(this, 0, "testUser"));

		// admin button  creates visible AdminForm
		af = bc.getAdminForm();
		assertNotNull(af);
		assertTrue(af.isVisible());
		
		// all other forms remain null
		cf = bc.getCredentialsForm();
		assertNull(cf);

		cef = bc.getCreateEventForm();
		assertNull(cef);
		

		// now tear down all and refresh forms, all should be null
		bc.tearDownForms();

		cef = bc.getCreateEventForm();
		assertNull(cef);

		cf = bc.getCredentialsForm();
		assertNull(cf);

		af = bc.getAdminForm();
		assertNull(af);
	}
	
	
}

	
	
