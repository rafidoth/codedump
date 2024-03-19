------- Install Neovim
------- create init.vim file in ~/.config/nvim/
------- Adding basic config
```
set number
syntax enable
set tabstop=4
set shiftwidth=4
set expandtab
set encoding=utf-8
filetype plugin indent on
```
------- Setup compiler
```
" Set C++ file type
autocmd BufNewFile,BufRead *.cpp set filetype=cpp

" Compile and run C++ program in subshell
function! CompileAndRun()
  let fileName = expand('%')
  if fileName =~ '\.cpp$'
    let exeName = substitute(fileName, '\.cpp$', '', '')
    execute 'w | !g++ -std=c++11 -Wall -Wextra -Wpedantic -O2 -o ' . exeName . ' ' . fileName
    if v:shell_error == 0
      let cmd = "x-terminal-emulator -e bash -c './" . exeName . "; read -p \"Press enter to exit...\"'"
      call system(cmd)
      redraw!
    endif
  else
    echo 'Not a C++ file'
  endif
endfunction
 
" Map keys to compile and run current file
map <F5> :call CompileAndRun()<CR>
map <F9> :w<CR>:!clear<CR>:call CompileAndRun()<CR>
```


------- Install vim plug
------- Install autopairs
------- Install coc-lsp plugin 

```
call plug#begin('~/.local/share/nvim/plugged')
 Plug 'jiangmiao/auto-pairs'
 Plug 'neoclide/coc.nvim', {'branch': 'release'}
call plug#end()
```

------ Configuring COC server
1. Installing language server not exist already
	-> check with clangd --version
2. Install clang plugin for coc
	```:CocInstall coc-clangd```
Now it should suggest language auto complete
3. create a coc.vim file in nvim directory in .config
4. in init.vim source the coc.vim
5. paste default configuration from coc github into coc.vim
https://github.com/neoclide/coc.nvim?tab=readme-ov-file#example-vim-configuration


It should work just fine!!!





