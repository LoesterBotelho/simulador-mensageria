package br.com.moredevs.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// ============================================================
// PROJETO DIDÁTICO - AULAS 1 E 2
// ============================================================
// Aula 1: Comunicação entre sistemas e versionamento de APIs.
// Aula 2: Mensageria - simulação de produtor, fila e consumidor.
// ============================================================

@SpringBootApplication
@EnableScheduling // AULA 2: permite que o consumidor verifique a fila periodicamente.
public class PedidosApplication {
    public static void main(String[] args) {
        SpringApplication.run(PedidosApplication.class, args);
    }
}
