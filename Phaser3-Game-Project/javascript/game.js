"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// FirstScene.ts
// Arquivo de programa da primeira cena do jogo
var PhaserGame;
(function (PhaserGame) {
    var FirstScene = /** @class */ (function (_super) {
        __extends(FirstScene, _super);
        // Construtor da classe
        function FirstScene() {
            // Inicializar pelo menos o nome da cena
            return _super.call(this, { key: 'FirstScene' }) || this;
        }
        // Método utilizado para inicializar a cena antes de ela aparecer
        FirstScene.prototype.preload = function () {
            this.load.image('Parede_Vertical', './assets/paredeV.png');
            this.load.image('Parede_Horizontal', './assets/paredeH.png');
            this.load.image('Chao_Inclinado', './assets/chao_inclinado.png');
            this.load.image('Chao_2', './assets/chao_2.png');
        };
        // Método utilizado para executar o jogo com suas definições iniciais
        FirstScene.prototype.create = function () {
            this.platforms = this.physics.add.staticGroup();
            this.platforms.create(530, 10, 'Parede_Vertical').refreshBody();
            this.platforms.create(270, 10, 'Parede_Vertical');
            this.platforms.create(270, 590, 'Parede_Vertical');
            this.platforms.create(530, 590, 'Parede_Vertical');
            this.platforms.create(10, 300, 'Parede_Horizontal');
            this.platforms.create(790, 300, 'Parede_Horizontal');
            this.platforms.create(507, 540, 'Chao_Inclinado');
            this.platforms.create(290, 420, 'Chao_2');
        };
        // Método utilizado para atualizar cada quadro do jogo
        FirstScene.prototype.update = function () {
        };
        return FirstScene;
    }(Phaser.Scene));
    PhaserGame.FirstScene = FirstScene;
})(PhaserGame || (PhaserGame = {}));
// init.ts
// Contém a classe InitPhaser que configura o ambiente do jogo
var PhaserGame;
(function (PhaserGame) {
    var InitPhaser = /** @class */ (function () {
        function InitPhaser() {
        }
        InitPhaser.initGame = function () {
            var config = {
                type: Phaser.CANVAS,
                width: 800,
                height: 600,
                scene: [PhaserGame.FirstScene],
                banner: true,
                backgroundColor: '#fff000',
                physics: {
                    default: 'arcade',
                    arcade: {
                        gravity: { y: 500 }
                    }
                },
                title: 'Joguinho irado',
                version: '1.0.0'
            };
            this.gameRef = new Phaser.Game(config);
        };
        return InitPhaser;
    }());
    PhaserGame.InitPhaser = InitPhaser;
})(PhaserGame || (PhaserGame = {}));
window.onload = function () {
    PhaserGame.InitPhaser.initGame();
};
//# sourceMappingURL=game.js.map