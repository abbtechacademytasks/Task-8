public class Main {
    public static void main(String[] args) {
        SimulatorHandler handler = new SimulatorHandler();
        handler.runSimulation();
    }
}


/*
BusStop-da iki fərqli ArrayDeque istifadə etmişəm prioritetlii və adi sərnişinlər üçün.
Əslində taskın məntiqinə PriorityQueue uyğun gəlirmiş kimi hiss olunur, sadəcə
PriorityQueue eyni prioritetdə olanda adamlara fifo-ya zəmanət vermir yəni düzgün
ardıcıllıqda olmayada bilər. Həmdəki log n məsələsinə görə optimal deyil. Adi ArrayDeque daha sürətlidir o(1).
*/