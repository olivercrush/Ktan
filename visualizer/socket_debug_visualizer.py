import sys, pygame
import threading
import socket
import json
import math

size = width, height = 1920, 1080

HEX_WIDTH = 200
HEX_HEIGTH = 200

GLOBAL_X_OFFSET = 300
GLOBAL_Y_OFFSET = 100

HOST = "127.0.0.1"
PORT = 65500

BLACK = 0, 0, 0
RED = 255, 0, 0
GREY = 128, 128, 128
WHITE = 255, 255, 255
YELLOW = 255, 255, 0
LIGHT_YELLOW = 128, 128, 0
ORANGE = 255, 128, 0
GREEN = 0, 255, 0
LIGHT_GREEN = 0, 128, 0

board_json = None
board_updated = False

def start_visualizer():
    global board_json
    global board_updated

    pygame.init()
    pygame.font.init()
    screen = pygame.display.set_mode(size)

    thread = threading.Thread(target=socket_thread, args=(1,), daemon=True)
    thread.start()

    screen.fill(BLACK)
    pygame.display.flip()

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()

        if board_json is not None and board_updated:
            board_updated = False
            screen.fill(BLACK)
            for y in range(len(board_json['hexGrid'])):
                for x in range(len(board_json['hexGrid'][y])):
                    draw_hexagone(screen, board_json['hexGrid'][y][x]['hexType'], board_json['hexGrid'][y][x]['diceTarget'], x, y)

            for y in range(len(board_json['locationGrid'])):
                for x in range(len(board_json['locationGrid'][y])):
                    draw_location(screen, board_json['locationGrid'][y][x], x, y)

            pygame.display.flip()

def socket_thread(name):
    global board_json
    global board_updated
    
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen()
        conn, addr = s.accept()

        with conn:
            while True:
                data = conn.recv(1024)

                if data:
                    f = open(data.decode('utf8').replace("\r\n", ""))
                    board_json = json.load(f)
                    f.close
                    board_updated = True
                    conn.sendall(data)

def draw_location(surface, type, x, y):
    x_offset = 0
    y_offset = 0
    if math.ceil(y / 2) % 2 == 0:
        x_offset = HEX_WIDTH / 2

    if y % 4 == 3:
        y_offset = HEX_HEIGTH
    elif y % 4 == 2:
        y_offset = HEX_HEIGTH / 4 * 3
    elif y % 4 == 1:
        y_offset = HEX_HEIGTH / 4

    display_x = x * HEX_WIDTH + x_offset + GLOBAL_X_OFFSET
    display_y = math.floor(y / 4) * (HEX_HEIGTH + HEX_HEIGTH / 2) + y_offset + GLOBAL_Y_OFFSET

    pygame.draw.circle(surface, RED, (display_x, display_y), 3)
    font = pygame.font.SysFont(None, 24)
    img = font.render("(" + str(x) + ";" + str(y) + ")", True, RED)
    surface.blit(img, (display_x + 5, display_y - 20))

def draw_hexagone(surface, type, dice_target, x, y):
    row_offset = 0
    col_offset = 0
    if y % 2 == 1:
        row_offset = HEX_WIDTH / 2

    center_x = x * HEX_WIDTH + row_offset + GLOBAL_X_OFFSET + HEX_WIDTH / 2
    center_y = y * (HEX_HEIGTH * 3 / 4) + GLOBAL_Y_OFFSET + HEX_HEIGTH / 2

    hex_vertices = (
        (center_x, center_y - HEX_HEIGTH / 2), 
        (center_x - HEX_WIDTH / 2, center_y - HEX_HEIGTH / 4), 
        (center_x - HEX_WIDTH / 2, center_y + HEX_HEIGTH / 4), 
        (center_x, center_y + HEX_HEIGTH / 2), 
        (center_x + HEX_WIDTH / 2, center_y + HEX_HEIGTH / 4), 
        (center_x + HEX_WIDTH / 2, center_y - HEX_HEIGTH / 4)
    )
    pygame.draw.polygon(surface, get_color_from_hex_type(type), hex_vertices)

    if type != "DESERT":
        font = pygame.font.SysFont(None, 24)
        img = font.render(str(dice_target), True, BLACK)
        surface.blit(img, (center_x, center_y))

def get_color_from_hex_type(hex_type):
    if hex_type == "FIELDS":
        return YELLOW
    elif hex_type == "FOREST":
        return GREEN
    elif hex_type == "PASTURE":
        return LIGHT_GREEN
    elif hex_type == "MOUNTAINS":
        return GREY
    elif hex_type == "HILLS":
        return ORANGE
    elif hex_type == "DESERT":
        return LIGHT_YELLOW

    return BLACK

start_visualizer()