package t05e04;

public class Temperatura {
    public static float celsiusParaKelvin(float C) {
        float K = C + 273;
        return K;
    }
    
    public static float kelvinParaCelsius(float K) {
        float C = K - 273;
        return C;
    }
    
    public static float celsiusParaFarenheit(float C) {
        float F = 9 * C / 5 + 32;
        return F;
    }
    
    public static float farenheitParaCelsius(float F) {
        float C = 5 * F / 9 - 32;
        return C;
    }
    
    public static float farenheitParaKelvin(float F) {
        float K = (F - 32) * 5/9 + 273;
        return K;
    }
    
    public static float kelvinParaFarenheit(float K) {
        float F = 9 * (K - 273) / 5 + 32;
        return F;
    }
}
