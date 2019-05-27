// FirstScene.ts
// Arquivo de programa da primeira cena do jogo
module PhaserGame {
    export class FirstScene extends Phaser.Scene {
        private platforms: Phaser.Physics.Arcade.StaticGroup | undefined;
        private hero: Phaser.Physics.Arcade.Sprite | undefined;
        private keyUp: Phaser.Input.Keyboard.Key | undefined;
        private keyDown: Phaser.Input.Keyboard.Key | undefined;
        private keyLeft: Phaser.Input.Keyboard.Key | undefined;
        private keyRight: Phaser.Input.Keyboard.Key | undefined;
        public constructor() {
            // Inicializar pelo menos o nome da cena
            super({
                key: 'FirstScene'
            });
        }
        // Método utilizado para inicializar a cena antes de ela aparecer
        public preload(): void {
            this.load.image('Parede_Vertical', './assets/paredeV.png');
            this.load.image('Parede_Horizontal', './assets/paredeH.png');
            this.load.image('Chao_Inclinado', './assets/chao_inclinado.png');
            this.load.image('Chao_2', './assets/chao_2.png');
            this.load.image('Hero', './assets/ghost.png');
        
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
            this.platforms.create(290,400,'Chao_2')
            this.platforms.create(507,260,'Chao_Inclinado')
            this.platforms.create(290,120,'Chao_2')

            this.hero = this.physics.add.sprite(40,565,'Hero');
            
            this.physics.add.collider(this.hero, this.platforms);
            this.keyUp = this.input.keyboard.addKey(Phaser.Input.Keyboard.KeyCodes.UP);
            this.keyDown = this.input.keyboard.addKey(Phaser.Input.Keyboard.KeyCodes.DOWN);
            this.keyLeft = this.input.keyboard.addKey(Phaser.Input.Keyboard.KeyCodes.LEFT);
            this.keyRight = this.input.keyboard.addKey(Phaser.Input.Keyboard.KeyCodes.RIGHT);
            



            
            
        }
        // Método utilizado para atualizar cada quadro do jogo
        public update(): void {
            if (this.hero) {
                if (this.keyUp && this.keyUp.isDown && this.hero.body.touching.down) {
                    console.log('UP is pressed');
                    this.hero.body.velocity.y = -320;
                }

                if (this.keyLeft && this.keyLeft.isDown) {
                    this.hero.body.velocity.x = -200;
                } else if (this.keyRight && this.keyRight.isDown) {
                    console.log('RIGHT is pressed');
                    this.hero.body.velocity.x = 200;
                }
                else {
                    this.hero.body.velocity.x = 0;
                }
            }

            
        }
    }
}
