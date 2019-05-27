// init.ts
// Contém a classe InitPhaser que configura o ambiente do jogo
module PhaserGame {
    export class InitPhaser {
        static gameRef: Phaser.Game;
        public static initGame(): void {
            let config: GameConfig = {
                type: Phaser.CANVAS,
                width: 800,
                height: 600,
                scene: [FirstScene],
                banner: true,
                backgroundColor: '#fff000' ,
                physics: {
                    default: 'arcade',
                    arcade: {
                        gravity: { y: 500 }
                    }
                },
                title: 'Joguinho irado',
                version: '1.0.0'
            }
            this.gameRef = new Phaser.Game(config);
        }
    }
}
window.onload = () => {
    PhaserGame.InitPhaser.initGame();
};
