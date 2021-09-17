package cbo.onborading.response_object;

public class EmployeeBranch {
    private String companyCode;
    private String branchName;

    public EmployeeBranch(String companyCode, String branchName) {
        this.companyCode=companyCode;
        this.branchName=branchName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
