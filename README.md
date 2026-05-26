# SmartInfra - Logística e Infraestrutura (Global Solution ODS 9)

## Sobre o Projeto
Este projeto foi desenvolvido em Java como parte da avaliação "Global Solution" focada no ODS 9 (Indústria, Inovação e Infraestrutura).
O sistema, chamado SmartInfra, simula uma plataforma de logística inteligente, onde veículos (Caminhões e Drones) são cadastrados e geridos para realizar entregas otimizadas, monitoradas e notificadas.

## Estrutura do Projeto
O projeto está organizado nos seguintes pacotes:
- `app`: Contém a classe `Main` com a interface de menu interativo (via `Scanner`).
- `abstracts`: Contém a classe abstrata base `Transporte`.
- `interfaces`: Define os comportamentos `Rastreavel` e `Notificavel`.
- `model`: Modelos de negócio, incluindo `Caminhao`, `Drone` e `Entrega` (demonstrando herança, sobrescrita e sobrecarga).
- `service`: Contém a classe `GerenciadorEntregas`, responsável por orquestrar a lógica.

## Conceitos de POO Aplicados
1. **Modelagem**: Divisão em pacotes, atributos privados e métodos públicos.
2. **Herança**: `Caminhao` e `Drone` herdam de `Transporte`.
3. **Classe Abstrata**: `Transporte` define atributos comuns e o método abstrato `calcularTempoEstimado()`.
4. **Interface**: `Rastreavel` e `Notificavel` padronizam comportamentos entre diferentes meios de transporte.
5. **Sobrescrita de Métodos (`@Override`)**: As classes filhas sobrescrevem o método abstrato `calcularTempoEstimado()`, além do método `toString()`.
6. **Sobrecarga de Métodos**: A classe `Entrega` possui construtores sobrecarregados (um com prioridade e outro padrão).
7. **Interação**: Utilizado o `Scanner` para criar um menu iterativo no terminal.

## Como Executar
1. Tenha o Java (JDK) instalado na sua máquina.
2. Clone o repositório.
3. Abra o projeto em uma IDE (IntelliJ, Eclipse, VSCode) ou compile via terminal.
4. Execute a classe `app.Main` para interagir com o menu.

## Integrantes
- Josué Faria - RM 563819
- Sofia Bomeny - RM 563270
- Vitor Bugallo - RM 562208
