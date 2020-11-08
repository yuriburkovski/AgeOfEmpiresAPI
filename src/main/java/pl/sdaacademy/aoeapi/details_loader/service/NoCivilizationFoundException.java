package pl.sdaacademy.aoeapi.details_loader.service;

public class NoCivilizationFoundException extends RuntimeException {
    public NoCivilizationFoundException(String name) {
        super(String.format("No civilization %s found!", name));
    }
}
