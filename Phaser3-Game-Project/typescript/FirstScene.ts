// FirstScene.ts
// Arquivo de programa da primeira cena do jogo
module PhaserGame {
    export class FirstScene extends Phaser.Scene {
        private platforms: Phaser.Physics.Arcade.StaticGroup | undefined;
        
       
       
       
        // Construtor da classe
        public constructor() {
            // Inicializar pelo menos o nome da cena
            super({ key: 'FirstScene' });

        }
        // Método utilizado para inicializar a cena antes de ela aparecer
        public preload(): void {
            this.load.image('Parede_Vertical', './assets/paredeV.png');
            this.load.image('Parede_Horizontal', './assets/paredeH.png');
            this.load.image('Chao_Inclinado', './assets/chao_inclinado.png');
            this.load.image('Chao_2', './assets/chao_2.png');
        
        }
        // Método utilizado para executar o jogo com suas definições iniciais
        public create(): void {
            this.platforms = this.physics.add.staticGroup();
            this.platforms.create(530,10,'Parede_Vertical').refreshBody();
            this.platforms.create(270,10,'Parede_Vertical')
            this.platforms.create(270,590,'Parede_Vertical')
            this.platforms.create(530,590,'Parede_Vertical')
            this.platforms.create(10,300,'Parede_Horizontal')
            this.platforms.create(790,300,'Parede_Horizontal')
            this.platforms.create(507,540,'Chao_Inclinado')
            this.platforms.create(290,420,'Chao_2')


            
            
        }
        // Método utilizado para atualizar cada quadro do jogo
        public update(): void {
            
        }
    }
}
