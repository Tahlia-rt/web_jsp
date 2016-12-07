package net.board.db;

import java.sql.Date;

public class BoardBean {

		private int B_NUM;
		private String B_NAME;
		private String B_PASS;
		private String B_SUBJECT;
		private String B_CONTENT;
		private String B_FILE;
		private int B_RE_REF;
		private int B_RE_LEV;
		private int B_RE_SEQ;
		private int B_READCOUNT;
		private Date B_DATE;
		public int getB_NUM() {
			return B_NUM;
		}
		public void setB_NUM(int b_NUM) {
			B_NUM = b_NUM;
		}
		public String getB_NAME() {
			return B_NAME;
		}
		public void setB_NAME(String b_NAME) {
			B_NAME = b_NAME;
		}
		public String getB_PASS() {
			return B_PASS;
		}
		public void setB_PASS(String b_PASS) {
			B_PASS = b_PASS;
		}
		public String getB_SUBJECT() {
			return B_SUBJECT;
		}
		public void setB_SUBJECT(String b_SUBJECT) {
			B_SUBJECT = b_SUBJECT;
		}
		public String getB_CONTENT() {
			return B_CONTENT;
		}
		public void setB_CONTENT(String b_CONTENT) {
			B_CONTENT = b_CONTENT;
		}
		public String getB_FILE() {
			return B_FILE;
		}
		public void setB_FILE(String b_FILE) {
			B_FILE = b_FILE;
		}
		public int getB_RE_REF() {
			return B_RE_REF;
		}
		public void setB_RE_REF(int b_RE_REF) {
			B_RE_REF = b_RE_REF;
		}
		public int getB_RE_LEV() {
			return B_RE_LEV;
		}
		public void setB_RE_LEV(int b_RE_LEV) {
			B_RE_LEV = b_RE_LEV;
		}
		public int getB_RE_SEQ() {
			return B_RE_SEQ;
		}
		public void setB_RE_SEQ(int b_RE_SEQ) {
			B_RE_SEQ = b_RE_SEQ;
		}
		public int getB_READCOUNT() {
			return B_READCOUNT;
		}
		public void setB_READCOUNT(int b_READCOUNT) {
			B_READCOUNT = b_READCOUNT;
		}
		public Date getB_DATE() {
			return B_DATE;
		}
		public void setB_DATE(Date b_DATE) {
			B_DATE = b_DATE;
		}


		
}
