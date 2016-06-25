package com.garrytrue.cleanarhitecturegitapi.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by garrytrue on 25.06.16.
 */
public class ProtectionDTO {


        @SerializedName("enabled")
        @Expose
        private Boolean enabled;
        @SerializedName("required_status_checks")
        @Expose
        private RequiredStatusChecksDTO requiredStatusChecks;

        /**
         * @return The enabled
         */
        public Boolean getEnabled() {
            return enabled;
        }

        /**
         * @param enabled The enabled
         */
        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        /**
         * @return The requiredStatusChecks
         */
        public RequiredStatusChecksDTO getRequiredStatusChecks() {
            return requiredStatusChecks;
        }

        /**
         * @param requiredStatusChecks The required_status_checks
         */
        public void setRequiredStatusChecks(RequiredStatusChecksDTO requiredStatusChecks) {
            this.requiredStatusChecks = requiredStatusChecks;
        }

    }
