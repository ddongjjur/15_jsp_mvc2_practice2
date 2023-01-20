package loginEx.DTO_prac;

import java.util.Date;

public class LoginExDTO {

	private String memberId;
	private String memerNm;
	private String imgNm;
	private String passwd;
	private String sex;
	private String birthDt;
	private String hp;
	private String smsstsYn;
	private String email;
	private String emailstsYn;
	private String zipCode;
	private String roadAddress;
	private String jibunAddress;
	private String namujiAddress;
	private Date joinDt;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemerNm() {
		return memerNm;
	}
	public void setMemerNm(String memerNm) {
		this.memerNm = memerNm;
	}
	public String getImgNm() {
		return imgNm;
	}
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDt() {
		return birthDt;
	}
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getSmsstsYn() {
		return smsstsYn;
	}
	public void setSmsstsYn(String smsstsYn) {
		this.smsstsYn = smsstsYn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailstsYn() {
		return emailstsYn;
	}
	public void setEmailstsYn(String emailstsYn) {
		this.emailstsYn = emailstsYn;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getJibunAddress() {
		return jibunAddress;
	}
	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}
	public String getNamujiAddress() {
		return namujiAddress;
	}
	public void setNamujiAddress(String namujiAddress) {
		this.namujiAddress = namujiAddress;
	}
	public Date getJoinDt() {
		return joinDt;
	}
	public void setJoinDt(Date joinDt) {
		this.joinDt = joinDt;
	}
	@Override
	public String toString() {
		return "LoginExDTO [memberId=" + memberId + ", memerNm=" + memerNm + ", imgNm=" + imgNm + ", passwd=" + passwd
				+ ", sex=" + sex + ", birthDt=" + birthDt + ", hp=" + hp + ", smsstsYn=" + smsstsYn + ", email=" + email
				+ ", emailstsYn=" + emailstsYn + ", zipCode=" + zipCode + ", roadAddress=" + roadAddress
				+ ", jibunAddress=" + jibunAddress + ", namujiAddress=" + namujiAddress + ", joinDt=" + joinDt + "]";
	}
	
	
}
