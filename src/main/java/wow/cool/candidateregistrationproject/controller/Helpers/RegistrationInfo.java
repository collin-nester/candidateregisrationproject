package wow.cool.candidateregistrationproject.controller.Helpers;

public class RegistrationInfo {

        public RegistrationInfo() {};

        public Integer posid;
        public Integer applicantid;

        public Integer getPosid() {
            return posid;
        }

        public void setPosid(Integer posid) {
            this.posid = posid;
        }

        public Integer getApplicantid() {
            return applicantid;
        }

        public void setApplicantid(Integer applicantid) {
            this.applicantid = applicantid;
        }

        @Override
        public String toString() {
            return "RegistrationInfo{" +
                    "posid=" + posid +
                    ", applicantid=" + applicantid +
                    '}';
        }
}
