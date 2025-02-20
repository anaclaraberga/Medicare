package br.com.start.medicare.enums;

public enum MedicalSpecialty {
    CARDIOLOGY("Cardiology"),
    DERMATOLOGY("Dermatology"),
    GYNECOLOGY("Gynecology"),
    PEDIATRICS("Pediatrics"),
    PSYCHIATRY("Psychiatry"),
    ONCOLOGY("Oncology"),
    ORTHOPEDICS("Orthopedics"),
    NEUROLOGY("Neurology"),
    OPHTHALMOLOGY("Ophthalmology"),
    OTOLARYNGOLOGY("Otolaryngology"),
    UROLOGY("Urology"),
    RADIOLOGY("Radiology"),
    ANESTHESIOLOGY("Anesthesiology"),
    EMERGENCY_MEDICINE("Emergency Medicine"),
    FAMILY_MEDICINE("Family Medicine"),
    INTERNAL_MEDICINE("Internal Medicine");

    private final String specialty;

    MedicalSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return specialty;
    }
}
