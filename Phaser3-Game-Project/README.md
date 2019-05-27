# Template para projetos Phaser 3 no Visual Studio Code

## Para usar este template
1. Este template possui as seguintes pastas e arquivos:
   ```
    ├── assets
    ├── dts
    │   └── phaser.d.ts
    ├── index.html
    ├── javascript
    ├── lib
    │   └── phaser.js
    ├── node_modules
    ├── package.json
    ├── package-lock.json
    ├── README.md
    ├── tsconfig.json
    └── typescript
        ├── FirstScene.ts
        └── init.ts    
   ```
2. Para criar um novo jogo, deverá ser alterado:
   * No arquivo `index.html`, alterar o título da janela e eventualmente cores, títulos etc que serão parte do fundo do jogo;
   * Na pasta `typescript`, alterar na configuração (`GameConfig`) a largura e altura da área do jogo (`width` e `height`), a lista de cenas (`scene`), o título (`title`) e a versão (`version`); 
   * Na pasta `typescript`, alterar o conteúdo do arquivo `FirstScene.ts` para alterar o código da primeira cena do jogo. Todo jogo tem que ter no mínimo uma cena. Pode-se adicionar outras cenas depois;
   * Adicionar à pasta `assets`, imagens e sons do jogo.
3. Para compilar o jogo. Este template já inclui uma instalação do compilador Typescript. Para compilar um projeto, abrir um terminal na pasta raiz do projeto e então executar `npm run tsc`. Este comando executará o Typescript sobre os arquivos do jogo que estão na pasta `typescript` e criará na pasta `javascript` um único arquivo com nome `game.js`, que já está incluído no arquivo `index.html`. O Typescript ficará ativo, recompilando qualquer modificação que você faça no jogo até que se digite `CTRL+C` para interrompê-lo. Depois basta reexecutar o comando `npm run tsc` para voltar a recompilar o projeto.
4. Para executar seu jogo. Este template já contém um servidor de testes, `http-server`. Para executá-lo, abrir um terminal na pasta raiz do projeto e nele executar `node run http-server ./ -c-1`. Verificar o número da porta (`port`) que aparecer no terminal. Depois, executar o jogo abrindo um navegador (de preferência o Chrome ou Firefox) e utilize a url `localhost:porta` (por exemplo `localhost:8080`);
