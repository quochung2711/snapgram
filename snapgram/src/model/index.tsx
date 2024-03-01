export type User = {
    name: string,
    username: string,
    email: string,
    password: string,
    isActive: boolean,
    roleId: number
}

export type Login = {
    username: string,
    password: string,
}