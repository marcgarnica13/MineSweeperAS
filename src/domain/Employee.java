package domain;

import javax.persistence.Id;

public class Employee {

		private int empId;
		private String empName;

		@Id
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
			
}
