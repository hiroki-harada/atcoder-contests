program question3
implicit none

    integer:: X, Y, A, B, C
    integer, allocatable, dimension(:):: p, q, r
    integer, allocatable, dimension(:):: eat_X, eat_Y
    integer:: cnt_eat_X, cnt_eat_Y
    integer:: i

    read(*,*) X, Y, A, B, C

    allocate(p(A), q(B), r(C))
    allocate(eat_X(X), eat_Y(Y))

    do i = 1, A; read(*,*) p(i); enddo
    do i = 1, B; read(*,*) q(i); enddo
    do i = 1, C; read(*,*) r(i); enddo

    ! 計算開始
    ! 赤いリンゴを食べる数
    cnt_eat_X = 0; eat_X = 0
    do i = 1, X
        eat_X(i) = maxval(p, mask=(p> maxval(eat_X)))
    enddo

    ! 緑のリンゴを食べる数
    cnt_eat_Y = 0; eat_Y = 0
    do i = 1, Y
        eat_Y(i) = maxval(q, mask=(q> maxval(eat_Y)))
    enddo

    ! 染色するりんご
    ! 赤に染色
    do while ( maxval(r) > minval(eat_X) )
        eat_X( minloc(eat_X) ) = maxval(r)
    enddo

    ! 緑に染色
    do while ( maxval(r) > minval(eat_Y) )
        eat_Y( minloc(eat_Y) ) = maxval(r)
    enddo

    ! 答え
    write(*,*) sum(eat_X) + sum(eat_Y)

end program question3