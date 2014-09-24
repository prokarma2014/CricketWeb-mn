package com.pkrm.cric.enrollment;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class EnrollmentForm extends DynaActionForm {

	private static final long serialVersionUID = -1298865081672138473L;

	@Override
	public void initialize(ActionMapping mapping) {
set("name","vishnu");
set("employeeId",1974);
set("personalHighscore","165*");
set("designation","dumbber");
set("bowlingBest","3/3");
set("projectName","nach");
set("petName","cd");
set("havePlayed","Yes");

	}

}
