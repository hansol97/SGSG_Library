package com.kh.model.vo;

public class Member {
    private int memberNo;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private int memberRole; // 관리자인지 회원인지 확인용 필드
    private int rentCount; // 대여 횟수
    private String rentBookNo; // 회원이 대여중인 책 번호
    public Member() {
        super();
    }
    public Member(int memberNo, String memberId, String memberPwd, String memberName, int memberRole, int rentCount,
            String rentBookNo) {
        super();
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberRole = memberRole;
        this.rentCount = rentCount;
        this.rentBookNo = rentBookNo;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPwd() {
        return memberPwd;
    }
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public int getMemberRole() {
        return memberRole;
    }
    public void setMemberRole(int memberRole) {
        this.memberRole = memberRole;
    }
    public int getRentCount() {
        return rentCount;
    }
    public void setRentCount(int rentCount) {
        this.rentCount = rentCount;
    }
    public String getRentBookNo() {
        return rentBookNo;
    }
    public void setRentBookNo(String rentBookNo) {
        this.rentBookNo = rentBookNo;
    }
    @Override
    public String toString() {
        return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
                + memberName + ", memberRole=" + memberRole + ", rentCount=" + rentCount + ", rentBookNo=" + rentBookNo
                + "]";
    }
    
    
}
